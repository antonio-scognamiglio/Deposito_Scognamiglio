package com.exercise.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity order.
 * Tabella: "orders"
 *
 * Relazioni:
 * - Un ordine appartiene a un solo utente (N → 1)
 * → FK fisica in orders: colonna "user_id"
 * - Un ordine si riferisce a un solo prodotto (1 → 1, forzatura per
 * l'esercizio)
 * → FK fisica in orders: colonna "product_id" con vincolo UNIQUE
 */
@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    // @Id + @GeneratedValue(IDENTITY) → primary key auto-incrementata dal DB
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * RELAZIONE: un ordine appartiene a un solo utente (N → 1)
     *
     * PERCHÉ ESISTE IL CAMPO "private User user"?
     * → Per la NAVIGAZIONE in codice: order.getUser() deve funzionare.
     * → Nel DB NON esiste una colonna "user": esiste SOLO la colonna "user_id"
     * (BIGINT).
     * → JPA, quando carica l'Order dal DB, legge user_id e poi carica l'oggetto
     * User
     * corrispondente (SELECT * FROM users WHERE id = ?), e lo mette in questo
     * campo.
     *
     * PERCHÉ @ManyToOne?
     * → Indica la direzione: "molti ordini → un solo utente".
     * → È la parte che GENERA la FK fisica in QUESTA tabella (orders).
     *
     * PERCHÉ @JoinColumn(name = "user_id")?
     * → Dà il NOME alla colonna FK nel DB: orders.user_id.
     * → Senza questo, JPA userebbe un nome generato (es. "user_id" comunque, ma è
     * meglio esplicitarlo).
     * → NON c'è vincolo UNIQUE qui (molti ordini possono avere lo stesso utente).
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /*
     * RELAZIONE: un ordine si riferisce a un solo prodotto, e viceversa (1 → 1)
     * Nota: forzatura per l'esercizio — nella realtà sarebbe ManyToMany (tabella
     * ponte)
     *
     * PERCHÉ ESISTE IL CAMPO "private Product product"?
     * → Per la NAVIGAZIONE in codice: order.getProduct() deve funzionare.
     * → Nel DB NON esiste una colonna "product": esiste SOLO la colonna
     * "product_id" (BIGINT).
     * → JPA, quando carica l'Order dal DB, legge product_id e poi carica l'oggetto
     * Product
     * corrispondente (SELECT * FROM products WHERE id = ?), e lo mette in questo
     * campo.
     *
     * PERCHÉ @OneToOne?
     * → Indica la direzione: "un ordine ↔ un solo prodotto" (in entrambe le
     * direzioni).
     * → È la parte che GENERA la FK fisica in QUESTA tabella (orders), con vincolo
     * UNIQUE.
     *
     * PERCHÉ @JoinColumn(name = "product_id")?
     * → Dà il NOME alla colonna FK nel DB: orders.product_id.
     * → Con vincolo UNIQUE: solo una riga di orders può puntare a un dato prodotto.
     */
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    /*
     * Campi dati dell'ordine
     *
     * Perché Integer invece di int?
     * 1. Prevenzione degli errori di "unboxing": L'uso di Integer (Wrapper) serve a 
     *    evitare che l'applicazione lanci una NullPointerException immediata durante 
     *    la mappatura (es. da DTO a Entity) o l'inizializzazione. Se usassimo 'int', 
     *    il sistema proverebbe a convertire un valore nullo in un numero, causando un 
     *    crash tecnico del thread.
     *
     * 2. Zona di Sicurezza (Buffer): Usare Integer crea una "zona di sicurezza". 
     *    Permette all'oggetto Order di esistere in memoria anche se il campo quantity 
     *    non è ancora stato popolato correttamente. Questo ci dà il controllo: invece 
     *    di crashare, possiamo validare il dato nel Service e decidere come gestire 
     *    il fallimento (es. lanciando un'eccezione di business chiara per l'utente).
     *
     * 3. Controllo Esplicito vs Crash Tecnico: Preferiamo gestire esplicitamente 
     *    gli errori di business (dati mancanti o errati) piuttosto che subire 
     *    crash tecnici imprevedibili dovuti a conversioni automatiche del linguaggio.
     *
     * Perché @Column(nullable = false)?
     * Mentre Integer offre flessibilità in memoria (Java), questa annotazione 
     * garantisce l'integrità dei dati a livello di storage (Database), 
     * assicurando che la colonna non accetti mai valori NULL.
     */
    @Column(nullable = false)
    private Integer quantity;
    private BigDecimal totalPrice;
    private LocalDateTime orderDate;
    private String status;
}
