package com.exercise.ecommerce.service;

import com.exercise.ecommerce.dto.request.ProductRequest;
import com.exercise.ecommerce.dto.response.ProductResponse;
import com.exercise.ecommerce.model.Product;
import com.exercise.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Service per l'entità Product.
 *
 * Responsabilità:
 *   - CRUD base sul prodotto (salvare, cercare, aggiornare, cancellare)
 *   - Conversione entity→DTO via ProductResponse.from()
 *
 * Perché setter inline e non factory sull'entità?
 *   → Stesso ragionamento di UserService: l'entità NON deve dipendere dal DTO.
 *   → Qui nel service (l'unico layer che vede entrambi) si fanno i setter.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /** GET tutti i prodotti. */
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(ProductResponse::from)
                .toList();
    }

    /** GET un prodotto per id. */
    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found: " + id));
        return ProductResponse.from(product);
    }

    /** CREAZIONE di un nuovo prodotto (id generato dal DB). */
    public ProductResponse createProduct(ProductRequest req) {
        Product product = new Product();
        product.setName(req.name());
        product.setDescription(req.description());
        product.setPrice(req.price());
        product.setAvailable(req.available());
        product.setBrand(req.brand());  // ← può essere null

        Product saved = productRepository.save(product);  // → INSERT INTO products (...) ...
        return ProductResponse.from(saved);
    }

    /** AGGIORNAMENTO di un prodotto esistente (per id). */
    public ProductResponse updateProduct(Long id, ProductRequest req) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found: " + id));

        // Sovrascrive i campi dal request
        product.setName(req.name());
        product.setDescription(req.description());
        product.setPrice(req.price());
        product.setAvailable(req.available());
        product.setBrand(req.brand());  // ← può essere null

        return ProductResponse.from(productRepository.save(product));  // → UPDATE products SET ... WHERE id = ?
    }

    /** CANCELLAZIONE di un prodotto per id. */
    public void deleteById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new NoSuchElementException("Product not found: " + id);
        }
        productRepository.deleteById(id);  // → DELETE FROM products WHERE id = ?
    }
}
