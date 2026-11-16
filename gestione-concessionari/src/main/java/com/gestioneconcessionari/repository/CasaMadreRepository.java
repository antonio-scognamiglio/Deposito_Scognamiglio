package com.gestioneconcessionari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestioneconcessionari.entity.CasaMadre;

public interface CasaMadreRepository extends JpaRepository<CasaMadre, Long> {
    // Query Name Convention
    List<CasaMadre> findByRagioneSociale(String ragioneSociale);

    List<CasaMadre> findByPaese(String paese);

    List<CasaMadre> findByAnnoFondazioneLessThan(Integer anno);
}