package com.gestioneconcessionari.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CASA_MADRE")
public class CasaMadre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ragione_sociale", length = 100, nullable = false)
    private String ragioneSociale;

    @Column(name = "sede_legale", length = 100, nullable = false)
    private String sedeLegale;

    @Column(name = "paese", length = 50, nullable = false)
    private String paese;

    @Column(name = "anno_fondazione")
    private Integer annoFondazione;

    @Column(name = "fatturato_annuo", precision = 15, scale = 2)
    private BigDecimal fatturatoAnnuo;

    // Lato proprietario: mappedBy sull'inverso
    // La regola dice dove c'è la lista va messo il OneToMany
    @OneToMany(mappedBy = "casaMadre")
    @JsonIgnore
    private List<Concessionario> concessionari = new ArrayList<>();
}