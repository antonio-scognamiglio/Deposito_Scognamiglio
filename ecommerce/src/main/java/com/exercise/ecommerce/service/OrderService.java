package com.exercise.ecommerce.service;

import com.exercise.ecommerce.dto.request.OrderRequest;
import com.exercise.ecommerce.dto.response.OrderResponse;
import com.exercise.ecommerce.model.Order;
import com.exercise.ecommerce.model.Product;
import com.exercise.ecommerce.model.User;
import com.exercise.ecommerce.repository.OrderRepository;
import com.exercise.ecommerce.repository.ProductRepository;
import com.exercise.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Service per l'entità Order.
 *
 * Responsabilità:
 *   - Business logic: validazione che utente e prodotto esitino (relazioni ManyToOne/OneToOne)
 *   - Orchestrazione: carica i riferimenti, popola i campi, salva
 *   - Conversione entity→DTO via OrderResponse.from()
 *
 * PERCHÉ DUE REPOSITORY (e non altri SERVICE)?
 *   → L'entità Order ha due relazioni (user e product).
 *   → Nel service devo caricare l'oggetto User e l'oggetto Product per:
 *       1. validare che esistano (altrimenti NoSuchElementException)
 *       2. assegnarli all'entità Order (order.setUser(user), order.setProduct(product))
 *   → Chiamo i REPOSITORY, non altri SERVICE, perché qui mi serve solo il DATO grezzo
 *     ("l'utente esiste?") — non la business logic di UserService (che ha le sue validazioni,
 *     la sua orchestrazione). OrderService è l'UNICO luogo che vede entrambe le entità insieme.
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    /**
     * GET tutti gli ordini.
     */
    public List<OrderResponse> findAll() {
        return orderRepository.findAll().stream()
                .map(OrderResponse::from)
                .toList();
    }

    /**
     * GET un ordine per id.
     */
    public OrderResponse findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Order not found: " + id));
        return OrderResponse.from(order);
    }

    /**
     * CREAZIONE di un nuovo ordine.
     * → Valida che utente, prodotto e quantità siano corretti, poi li assegna all'entità.
     * → L'id NON viene dal request (lo genera il DB via @GeneratedValue).
     */
    public OrderResponse createOrder(OrderRequest req) {
        // La validazione della forma del dato (quantity > 0) è già garantita dal controller
        // via @Valid + @Min(1) sul DTO → qui restano solo i check delle RELAZIONI.

        // Validazione: l'utente deve esistere
        User user = userRepository.findById(req.userId())
                .orElseThrow(() -> new NoSuchElementException("User not found: " + req.userId()));

        // Validazione: il prodotto deve esistere
        Product product = productRepository.findById(req.productId())
                .orElseThrow(() -> new NoSuchElementException("Product not found: " + req.productId()));

        // Costruisco l'entità e assegno le relazioni + i campi dati
        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setQuantity(req.quantity());
        order.setTotalPrice(req.totalPrice());
        order.setOrderDate(req.orderDate());
        order.setStatus(req.status());

        Order saved = orderRepository.save(order);  // → INSERT INTO orders (...) ...
        return OrderResponse.from(saved);
    }

    /**
     * AGGIORNAMENTO di un ordine esistente (per id).
     */
    public OrderResponse updateOrder(Long id, OrderRequest req) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Order not found: " + id));

        // La validazione della forma del dato (quantity > 0) è già garantita dal controller
        // via @Valid + @Min(1) sul DTO → qui restano solo i check delle RELAZIONI.

        // Validazione: l'utente deve esistere
        User user = userRepository.findById(req.userId())
                .orElseThrow(() -> new NoSuchElementException("User not found: " + req.userId()));

        // Validazione: il prodotto deve esistere
        Product product = productRepository.findById(req.productId())
                .orElseThrow(() -> new NoSuchElementException("Product not found: " + req.productId()));

        // Sovrascrive le relazioni e i campi dati
        order.setUser(user);
        order.setProduct(product);
        order.setQuantity(req.quantity());
        order.setTotalPrice(req.totalPrice());
        order.setOrderDate(req.orderDate());
        order.setStatus(req.status());

        return OrderResponse.from(orderRepository.save(order));  // → UPDATE orders SET ... WHERE id = ?
    }

    /**
     * CANCELLAZIONE di un ordine per id.
     */
    public void deleteById(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new NoSuchElementException("Order not found: " + id);
        }
        orderRepository.deleteById(id);  // → DELETE FROM orders WHERE id = ?
    }
}
