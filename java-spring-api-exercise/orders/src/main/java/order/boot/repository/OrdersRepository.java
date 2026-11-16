package order.boot.repository;

import order.boot.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdersRepository  extends JpaRepository<OrdersEntity,Long> {

    //Questo è un Query Method o Derived Query o secondo il prof Name Convention
    Optional<OrdersEntity> findFirstByOrderByTotalDesc();

    //Con SQL Nativo
    //@Query(value = "SELECT * FROM orders_entity ORDER BY total DESC LIMIT 1", nativeQuery = true)
    //Optional<OrdersEntity> findFirstByOrderByTotalDesc();

    //Con JPQL
    //@Query("SELECT o FROM OrdersEntity o ORDER BY o.total DESC")
    //List<OrdersEntity> findFirstByOrderByTotalDesc(Pageable pageable);
}
