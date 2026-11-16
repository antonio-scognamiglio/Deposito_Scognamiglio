package com.exercise.ecommerce.dto.response;

import com.exercise.ecommerce.model.Brand;
import java.math.BigDecimal;

/**
 * Response DTO per il prodotto.
 *
 * --- ARCHITETTURA E FLUSSO DI DATI ---
 * Questo DTO viene utilizzato per restituire i dati del prodotto al client
 * dopo una richiesta di visualizzazione (es. GET /products/{id}).
 *
 * --- SCELTE DI TIPO ---\n * Usiamo 'Boolean' per il campo 'available' per garantire la coerenza con
 * le entità e i DTO di richiesta, evitando rischi di NullPointerException
 * durante la mappatura e mantenendo la flessibilità del Wrapper.
 *
 * @param id Identificativo univoco del prodotto
 * @param name Nome del prodotto
 * @param description Descrizione del prodotto
 * @param price Prezzo del prodotto
 * @param available Disponibilità del prodotto (Boolean per coerenza)
 * @param brand Marca del prodotto
 */
public record ProductResponse(
        Long id,
        String name,
        String description,
        BigDecimal price,
        Boolean available,
        Brand brand
) {

    /**
     * Conversione entity → ProductResponse.
     * \"So come costruire me stesso da un'entità\":
     *   product.getId()         → questo record.id
     *   product.getName()       → questo record.name
     *   product.getDescription() → questo record.description
     *   product.getPrice()      → questo record.price
     *   product.getAvailable()  → questo record.available
     *   product.getBrand()      → questo record.brand
     *
     * Il service lo usa come: .map(ProductResponse::from) — una riga, niente metodo private.
     */
    public static ProductResponse from(com.exercise.ecommerce.model.Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getAvailable(),
                product.getBrand()
        );
    }
}
