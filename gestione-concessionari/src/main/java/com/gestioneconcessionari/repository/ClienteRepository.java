package com.gestioneconcessionari.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestioneconcessionari.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Query Name Convention
    List<Cliente> findByNome(String nome);

    List<Cliente> findByCognome(String cognome);

    Optional<Cliente> findByEmail(String email);

    List<Cliente> findByNomeAndCognome(String nome, String cognome);

    // JPQL Clienti per concessionario
    @Query("""
                SELECT c
                FROM Cliente c
                JOIN c.concessionario co
                WHERE co.id = :id
            """)
    List<Cliente> findClientiByConcessionarioId(@Param("id") Long id);

    // JPQL Ricerca dinamica clienti
    @Query("""
                SELECT c
                FROM Cliente c
                WHERE (:nome IS NULL OR c.nome = :nome)
                  AND (:cognome IS NULL OR c.cognome = :cognome)
            """)
    List<Cliente> findClientiByNomeECognome(@Param("nome") String nome, @Param("cognome") String cognome);
}
