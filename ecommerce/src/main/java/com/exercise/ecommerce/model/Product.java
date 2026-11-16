package com.exercise.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Entity product.
 * Tabella: "products"
 *
 * Relazioni:
 *   - Un prodotto sta in un solo ordine (1 → 1, forzatura per l'esercizio)
 *     → qui NON c'è alcuna FK nella tabella products.
 *       La FK fisica è nel lato owner (Order, colonna "product_id").
 *  */
@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campi dati del prodotto
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private BigDecimal price;

    @Column(nullable = false)
    private Boolean available;

    /*
     * MARCA: un valore dell'enum Brand, o null se non dichiarata.
     *
     * PERCHÉ @Enumerated(EnumType.STRING)?
     *   → JPA serializza l'enum come STRINGA nel DB (es. "APPLE", "SAMSUNG", ...).
     *   → Senza @Enumerated, JPA userebbe ORDINAL (int: 0,1,2,...) — meno leggibile.
     *   → Con EnumType.STRING, la colonna nel DB è VARCHAR e resta leggibile.
     *
     * PERCHÉ nullable (null)?
     *   → null significa "marca non dichiarata / sconosciuta".
     *   → L'enum contiene SOLO i valori conosciuti; se la marca non c'è tra quelle,
     *     il campo resta null. NON esiste un valore "OTHER" nell'enum.
     *  */
    @Enumerated(EnumType.STRING)
    private Brand brand;

    /*
     * --- ARCHITETTURA DELLA RELAZIONE 1:1 ---
     * 
     * Concetto chiave: Dipendenza vs. Reciprocità.
     * Anche se un rapporto è 1:1, nel database non possono esserci due Foreign Keys 
     * reciproche (es. un 'product_id' in orders e un 'order_id' in products).
     *
     * Perché?
     * → Dipendenza Circolare: Se entrambe le tabelle avessero una FK verso l'altra,
     *   il database non permetterebbe di inserire nessuna delle due (perché ognuna 
     *   richiederebbe l'esistenza dell'altra per essere salvata).
     *
     * Soluzione:
     * → Dobbiamo scegliere un "Owner" (Proprietario) della relazione.
     * → L'Owner è l'entità che "dipende" dall'altra e che conterrà fisicamente
     *   la colonna della Foreign Key nel database.
     *
     * In questo esercizio:
     *   → L'entità 'Order' è il dipendente (Owner della FK).
     *   → L'entità 'Product' è il "genitore" (non ha FK nel DB, ma viene
     *     "letta" tramite il mapping mappedBy).
     *
     * RELAZIONE: un prodotto sta in un solo ordine (1 → 1)
     * Nota: forzatura per l'esercizio — nella realtà sarebbe ManyToMany
     *
     * PERCHÉ ESISTE IL CAMPO "private Order order"?
     *   → Per la NAVIGAZIONE in codice: product.getOrder() deve funzionare.
     *   → Nel DB NON esiste una colonna "order" in products: NON c'è alcuna FK qui.
     *   → La FK fisica è in orders (colonna "product_id").
     *   → JPA, quando carica il Product dal DB, non ha bisogno di caricare l'Order
     *     da questo lato: per ricostruire la relazione, guarda il campo "order" di
     *     Order.
     *
     * PERCHÉ mappedBy = "product"?
     *   → Dice a JPA: "per navigare da Product a Order, guarda il campo 'product' di Order
     *     (che mappà la FK product_id in orders)".
     *   → Il nome DEVE coincidere ESATTAMENTE con il nome del campo in Order:
     *       private Product product;  ← questo "product" è quello che mappa qui.
     *   → NON genera una FK in products. Serve SOLO per la navigazione inversa.
     *
     * COSA FA JPA IN REALTÀ?
     *   → Quando chiami product.getOrder(), JPA genera la query:
     *       SELECT * FROM orders WHERE product_id = ?   (dove ? è l'id del product)
     *   → La prima volta esegue una vera SELECT; le volte successive usa la cache.
     *  */
    @OneToOne(mappedBy = "product")
    private Order order;
}
