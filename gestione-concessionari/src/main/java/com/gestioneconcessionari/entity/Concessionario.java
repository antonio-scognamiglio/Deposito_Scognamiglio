package com.gestioneconcessionari.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CONCESSIONARIO")
public class Concessionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "citta", length = 100, nullable = false)
    private String citta;

    @Column(name = "indirizzo", length = 150)
    private String indirizzo;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "fatturato", precision = 15, scale = 2)
    private BigDecimal fatturato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "casa_madre_id")
    private CasaMadre casaMadre;

    @OneToMany(mappedBy = "concessionario")
    @JsonIgnore
    private List<Cliente> clienti = new ArrayList<>();
}