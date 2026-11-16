package order.boot.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import order.boot.entity.OrdersEntity;
import order.boot.model.response.OrderResponse;
import order.boot.repository.OrdersRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        super();
        this.ordersRepository = ordersRepository;
    }

    public List<OrderResponse> getAllOrders() {
        List<OrdersEntity> entity = ordersRepository.findAll();

        return entity.stream().map(map -> new OrderResponse(
                map.getId(),
                map.getLocalDateTime(),
                map.getTotal(),
                map.getProducts()))
                .toList();
    }

    public OrderResponse getOrderById(Long id) {
        Optional<OrdersEntity> entity = ordersRepository.findById(id);
        return entity.isPresent() ? new OrderResponse(id, entity.get().getLocalDateTime(),
                entity.get().getTotal(), entity.get().getProducts())
                : new OrderResponse(null, null, null, null);
    }

    public OrderResponse saveNewOrder(BigDecimal totale, String lsIdProducts) {
        OrdersEntity createEntity = new OrdersEntity();
        createEntity.setProducts(lsIdProducts);
        createEntity.setTotal(totale);
        OrdersEntity entity = ordersRepository.saveAndFlush(createEntity);

        return new OrderResponse(entity.getId(), entity.getLocalDateTime(),
                entity.getTotal(), entity.getProducts());
    }

    public void deleteOrderById(Long id) {
        // 1. Controlla se esiste
        if (!ordersRepository.existsById(id)) {
            // Lanci un'eccezione personalizzata o una standard
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordine non trovato");
        }
        ordersRepository.deleteById(id);

    }
}