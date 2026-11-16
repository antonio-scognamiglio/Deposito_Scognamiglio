package com.exercise.ecommerce.dto.response;

import com.exercise.ecommerce.model.User;

/**
 * Response DTO per le risposte HTTP (GET /users, GET /users/{id}, POST, PUT).
 *
 * CON id → perché il DB l'ha già generato e vogliamo restituirlo al client.
 *
 * Record → immutabile, zero boilerplate.
 *
 * PERCHÉ C'È IL METODO STATICO "from"?
 *   → Il record SA da dove viene: ha gli stessi campi dell'entità User.
 *   → La conversione entity→DTO è una CONOSCENZA DEL TIPO RESPONSE, non del service.
 *   → Così il service diventa SOLO orchestrazione + business logic, senza mapper private.
 *   → E nel code basta: .map(UserResponse::from) — zero boilerplate.
 */
public record UserResponse(Long id, String firstName, String lastName, String email) {

    /**
     * Conversione entity → UserResponse.
     *
     * "So come costruire me stesso da un'entità":
     *   user.getId()         → questo record.id
     *   user.getFirstName()  → questo record.firstName
     *   user.getLastName()   → questo record.lastName
     *   user.getEmail()      → questo record.email
     *
     * Il service lo usa come: .map(UserResponse::from) — una riga, niente metodo private.
     */
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }
}
