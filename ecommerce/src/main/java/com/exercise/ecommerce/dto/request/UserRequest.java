package com.exercise.ecommerce.dto.request;

import jakarta.validation.constraints.NotNull;

/**
 * Request DTO per la CREAZIONE e l'AGGIORNAMENTO di un utente (body di POST/PUT).
 *
 * --- ARCHITETTURA E FLUSSO DI DATI ---
 * Quando una richiesta arriva al controller, Spring Boot utilizza la libreria 
 * JACKSON come motore di deserializzazione. Jackson analizza il corpo della 
 * richiesta (JSON) e tenta di "mappare" ogni chiave JSON sui campi del nostro 
 * record UserRequest.
 *
 * SENZA id → perché:
 *   - Nel POST, l'id è generato dal DB (@GeneratedValue): il client non lo manda.
 *   - Nel PUT, l'id è nel path (/users/{id}), non nel body.
 *
 * @param firstName Nome dell'utente (Obbligatorio)
 * @param lastName Cognome dell'utente (Obbligatorio)
 * @param email Email dell'utente (Obbligatoria)
 */
public record UserRequest(
        @NotNull String firstName,
        @NotNull String lastName,
        @NotNull String email
) {
}
