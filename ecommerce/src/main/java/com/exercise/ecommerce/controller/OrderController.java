package com.exercise.ecommerce.controller;

import com.exercise.ecommerce.dto.request.OrderRequest;
import com.exercise.ecommerce.dto.response.OrderResponse;
import com.exercise.ecommerce.service.OrderService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Controller REST per gli ordini.
 *
 * Endpoints:
 * GET /orders → tutti gli ordini
 * GET /orders/{id} → un ordine per id
 * POST /orders → crea un nuovo ordine
 * PUT /orders/{id} → aggiorna un ordine esistente
 * DELETE /orders/{id} → cancella l'ordine
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /** GET /orders → lista tutti gli ordini */
    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAll());
    }

    /** GET /orders/{id} → recupera un ordine per id */
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    /**
     * POST /orders → crea un nuovo ordine dal body JSON (OrderRequest, senza id)
     */
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(req));
    }

    /**
     * PUT /orders/{id} → aggiorna l'ordine con il body JSON (OrderRequest, senza
     * id)
     */
    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable Long id, @Valid @RequestBody OrderRequest req) {
        return ResponseEntity.ok(orderService.updateOrder(id, req));
    }

    /** DELETE /orders/{id} → cancella l'ordine (204 No Content) */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /** Handler: trasforma NoSuchElementException in HTTP 404 */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
