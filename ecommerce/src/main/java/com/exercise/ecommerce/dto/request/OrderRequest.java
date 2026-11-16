package com.exercise.ecommerce.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Request DTO per la CREAZIONE e l'AGGIORNAMENTO di un ordine (body di
 * POST/PUT).
 *
 * SENZA id → perché:
 * - Nel POST, l'id è generato dal DB (@GeneratedValue): il client non lo manda.
 * - Nel PUT, l'id è nel path (/orders/{id}), non nel body.
 *
 * userId e productId → per validare le relazioni nel service
 * (l'entità usa oggetti User/Product, ma il JSON ha solo gli id).
 *
 * --- ANALISI DEL CAMPO "quantity" ---
 * Abbiamo scelto l'uso di 'Integer' (Wrapper) accoppiato a '@NotNull' e '@Min(1)'
 * per una ragione fondamentale di robustezza:
 *
 * 1. Gestione dei campi omessi:
 *    Se il client omette il campo "quantity" nel JSON:
 *    - Con Integer + @NotNull: Jackson lascia il valore a NULL. Spring (tramite 
 *      Bean Validation) rileva il NULL e restituisce un errore 400. Questo è
 *      il comportamento desiderato: il dato è mancante.
 *    - Con int (primitivo): Jackson non può assegnare NULL a un primitivo, quindi 
 *      assegna automaticamente lo 0 di default. Il sistema non riuscirebbe a 
 *      distinguere tra "utente non ha inviato il dato" e "utente ha voluto inviare 0".
 *
 * 2. Precisione della Validazione:
 *    Usando @NotNull, garantiamo che il dato sia presente. Usando @Min(1), 
 *    garantiamo che il dato sia valido per il business. Questa combinazione 
 *    ferma la richiesta prima ancora che raggiunga il Service o il Database.

 */
public record OrderRequest(
                Long userId,
                Long productId,
                @Min(1) @NotNull Integer quantity,
                BigDecimal totalPrice,
                LocalDateTime orderDate,
                String status) {
}
