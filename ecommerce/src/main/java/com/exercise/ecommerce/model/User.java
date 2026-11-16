package com.exercise.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity user.
 * Tabella: "users"
 *
 * Relazioni:
 * - Un utente può avere più ordini (1 → N)
 * La FK fisica è nella tabella orders (colonna "user_id").
 * In users NON esiste alcuna FK.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    /*
     * RELAZIONE: un utente può avere più ordini (1 → N)
     *
     * PERCHÉ ESISTE QUESTO CAMPO?
     * → Per la NAVIGAZIONE in codice: user.getOrders() deve funzionare.
     * → Senza questo campo, non potresti scrivere user.getOrders().
     * → Non è una colonna nel DB (in users NON c'è alcuna FK).
     *
     * PERCHÉ mappedBy = "user"?
     * → Dice a JPA: "per ricostruire la lista di ordini di un utente,
     * guarda il campo 'user' di Order (che mappà la FK user_id)".
     * → Senza mappedBy, JPA non sa da quale lato della relazione partire.
     * → Il nome DEVE coincidere ESATTAMENTE con il nome del campo in Order:
     * private User user; ← questo "user" è quello che mappa qui.
     *
     * COSA FA JPA IN REALTÀ?
     * → Quando chiami user.getOrders(), JPA genera la query:
     * SELECT * FROM orders WHERE user_id = ? (dove ? è l'id del user)
     * → La prima volta esegue una vera SELECT; le volte successive usa la cache.
     */
    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();
}
