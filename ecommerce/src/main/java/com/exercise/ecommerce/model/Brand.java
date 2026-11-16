package com.exercise.ecommerce.model;

/**
 * Enum per la marca di un prodotto.
 *
 * Opzione NULLABLE (Opzione B):
 *   → L'enum rappresenta SOLO i valori CONOSCIUTI (4 marche).
 *   → Nel DB, null significa "marca non dichiarata / sconosciuta".
 *   → Non c'è un valore "OTHER": se la marca non è tra le 4, il campo resta null.
 *
 * Serializzazione JPA: @Enumerated(EnumType.STRING) nel campo dell'entità
 *   → nel DB si salva come VARCHAR (es. "APPLE", "SAMSUNG", ... oppure NULL).
 */
public enum Brand {
    APPLE,
    SAMSUNG,
    HONOR,
    XIAOMI
}
