package com.exercise.ecommerce.controller;

import com.exercise.ecommerce.dto.request.ProductRequest;
import com.exercise.ecommerce.dto.response.ProductResponse;
import com.exercise.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Controller REST per i prodotti.
 *
 * Endpoints:
 *   GET    /products      → tutti i prodotti
 *   GET    /products/{id} → un prodotto per id
 *   POST   /products      → crea un nuovo prodotto
 *   PUT    /products/{id} → aggiorna un prodotto esistente
 *   DELETE /products/{id} → cancella il prodotto
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /** GET /products → lista tutti i prodotti */
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    /** GET /products/{id} → recupera un prodotto per id */
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    /** POST /products → crea un nuovo prodotto dal body JSON (ProductRequest, senza id) */
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(req));
    }

    /** PUT /products/{id} → aggiorna il prodotto con il body JSON (ProductRequest, senza id) */
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest req) {
        return ResponseEntity.ok(productService.updateProduct(id, req));
    }

    /** DELETE /products/{id} → cancella il prodotto (204 No Content) */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /** Handler: trasforma NoSuchElementException in HTTP 404 */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
