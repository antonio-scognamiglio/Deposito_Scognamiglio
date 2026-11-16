package com.exercise.ecommerce.repository;

import com.exercise.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository per l'entità Order.
 *
 * Estende JpaRepository<Order, Long>, che fornisce già tutte le operazioni base:
 *   - findAll()           → SELECT * FROM orders
 *   - findById(id)        → SELECT * FROM orders WHERE id = ?
 *   - save(order)         → INSERT o UPDATE (a seconda se l'entità ha un id)
 *   - deleteById(id)      → DELETE FROM orders WHERE id = ?
 *   - existsById(id)      → SELECT 1 FROM orders WHERE id = ? LIMIT 1
 *
 * PERCHÉ NON CI STA @Repository?
 *   → Con Spring Data JPA, l'annotazione è REDUNDANTE.
 *   → COSA FA SPRING "SOTTO IL COFANO"?
 *       1. Al boot, la JpaRepositoriesAutoConfiguration scannerizza il classpath.
 *       2. Trova ogni interface che estende JpaRepository<..., ...>.
 *       3. Crea automaticamente un bean (proxy) con l'implementazione query-by-name.
 *       4. Lo registra nel container di Spring senza bisogno di annotazioni.
 *   → Quindi: basta estendere JpaRepository, e il bean esiste già.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Nessuna query custom necessaria per il CRUD base:
    // JpaRepository genera tutto automaticamente dal nome dei metodi.
}
