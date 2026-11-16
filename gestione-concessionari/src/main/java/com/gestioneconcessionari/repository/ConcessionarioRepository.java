package com.gestioneconcessionari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestioneconcessionari.entity.Concessionario;

import java.math.BigDecimal;
import java.util.List;

public interface ConcessionarioRepository extends JpaRepository<Concessionario, Long> {
    // Query Name Convention
    List<Concessionario> findByCitta(String citta);

    List<Concessionario> findByFatturatoGreaterThan(BigDecimal x);

    List<Concessionario> findByFatturatoBetween(BigDecimal a, BigDecimal b);

    // JPQL Concessionari per casamadre con JOIN
    @Query("""
                SELECT c
                FROM Concessionario c
                JOIN c.casaMadre cm
                WHERE cm.ragioneSociale = :ragioneSociale
            """)
    List<Concessionario> findConcessionariByCasaMadreRagioneSociale(@Param("ragioneSociale") String ragioneSociale);

    // JPQL Concessionari sopra la media
    @Query("""
                SELECT c
                FROM Concessionario c
                WHERE c.fatturato > (SELECT AVG(c2.fatturato) FROM Concessionario c2)
            """)
    List<Concessionario> findConcessionariSopraMedia();

}
