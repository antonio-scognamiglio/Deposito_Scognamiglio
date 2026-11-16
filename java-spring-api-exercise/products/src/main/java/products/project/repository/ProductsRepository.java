package products.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import products.project.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.List;

/**
    * La repository interagisce con il db, prende i dati grezzi diciamo
    * funge da magazzino di metodi che interrogano il db
 */
@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, Long>{

    //Con SQL Nativo
    @Query(value = "SELECT * FROM prodotti WHERE prezzo BETWEEN :min AND :max ORDER BY prezzo ASC", nativeQuery = true)
    List<ProductEntity> findByPriceRangeNative(
            @Param("min") BigDecimal min,
            @Param("max") BigDecimal max
    );

    //Con JPQL
    /*
    @Query("SELECT p FROM ProductEntity p WHERE p.price BETWEEN :min AND :max")
    List<ProductEntity> findByPriceRange(@Param("min") BigDecimal min, @Param("max") BigDecimal max);
    */
}