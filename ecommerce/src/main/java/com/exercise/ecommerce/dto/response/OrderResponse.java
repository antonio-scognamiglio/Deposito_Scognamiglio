package com.exercise.ecommerce.dto.response;

import com.exercise.ecommerce.model.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Response DTO per le risposte HTTP (GET /orders, GET /orders/{id}, POST, PUT).
 *
 * --- ARCHITETTURA E FLUSSO DI DATI ---
 * Questo DTO viene utilizzato per restituire i dati di un ordine al client.
 *
 * CON id → perché il DB l'ha già generato e vogliamo restituirlo al client.
 * userId/productId → gli id delle relazioni (non gli oggetti interi: il client
 *   ha già gli id nel request e non serve caricare tutto in ogni risposta).
 *
 * --- SCELTE DI TIPO ---
 * Usiamo 'Integer' per 'quantity' per coerenza con la nostra strategia di
 * usare i Wrapper e garantire la sicurezza durante la mappatura.
 *
 * Record → immutabile, zero boilerplate.
 *
 * Factory static "from" → la conversione entity→DTO è una CONOSCENZA DEL TIPO RESPONSE.
 *  */
public record OrderResponse(
        Long id,
        Long userId,
        Long productId,
        Integer quantity,
        BigDecimal totalPrice,
        LocalDateTime orderDate,
        String status
) {

    /**
     * Conversione entity → OrderResponse.
     * \"So come costruire me stesso da un'entità\":
     *   order.getId()         → questo record.id
     *   order.getUser().getId()  → questo record.userId
     *   order.getProduct().getId() → questo record.productId
     *   ...
     *
     * Il service lo usa come: .map(OrderResponse::from) — una riga, niente metodo private.
     */
    public static OrderResponse from(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getUser().getId(),
                order.getProduct().getId(),
                order.getQuantity(), // Java farà l'autoboxing da int a Integer
                order.getTotalPrice(),
                order.getOrderDate(),
                order.getStatus()
        );
    }
}
