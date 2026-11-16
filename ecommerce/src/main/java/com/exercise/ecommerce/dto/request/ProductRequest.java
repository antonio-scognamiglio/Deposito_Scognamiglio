package com.exercise.ecommerce.dto.request;

import com.exercise.ecommerce.model.Brand;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Request DTO per la CREAZIONE e l'AGGIORNAMENTO di un prodotto (body di POST/PUT).
 *
 * --- ARCHITETTURA E FLUSSO DI DATI ---
 * Quando una richiesta arriva al controller, Spring Boot utilizza la libreria 
 * JACKSON come motore di deserializzazione. Jackson analizza il corpo della 
 * richiesta (JSON) e tenta di "mappare" ogni chiave JSON sui campi del nostro 
 * record ProductRequest.
 *
 * --- ANALISI DEL CAMPO "available" ---
 * Abbiamo scelto l'uso di 'Boolean' (Wrapper) accoppiato a un'eventuale 
 * validazione per gestire correttamente i campi omessi nel JSON, evitando 
 * assegnazioni automatiche a 'false' tipiche del tipo primitivo.
 *
 * --- RELAZIONI ---
 * brand → nullable (Opzione B): null = "marca non dichiarata".
 *   Jackson serializza: se il JSON ha "brand": null -> brand = null.
 *   Se il JSON NON ha il campo "brand" -> brand = null (default).
 *
 * SENZA id → perché:
 *   - Nel POST, l'id è generato dal DB (@GeneratedValue): il client non lo manda.
 *   - Nel PUT, l'id è nel path (/products/{id}), non nel body.
 *
 * @param name Nome del prodotto (Obbligatorio)
 * @param description Descrizione del prodotto (Obbligatoria)
 * @param price Prezzo del prodotto (Obbligatorio)
 * @param available Disponibilità del prodotto
 * @param brand Marca del prodotto
 */
public record ProductRequest(
        @NotNull String name,
        @NotNull String description,
        @NotNull BigDecimal price,
        Boolean available,
        Brand brand
) {
}
