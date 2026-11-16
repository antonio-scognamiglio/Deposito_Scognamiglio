package es02.dipendenti.models;

/**
 * Classe astratta DipendenteAstratto: contiene le caratteristiche comuni
 * a TUTTI i dipendenti (ID, Nome, Cognome, Orario).
 * 
 * Perché è 'abstract'? Perché un "dipendente generico" non esiste nella realtà;
 * esistono solo dipendenti specifici (FullTime, PartTime, ecc.).
 */
public abstract class DipendenteAstratto implements Dipendente {
    // 'protected' permette alle classi figlie di accedere direttamente a queste
    // variabili
    // ma le nasconde al resto del programma (incapsulamento).
    protected Long id;
    protected String nome;
    protected String cognome;
    protected int orario;

    /**
     * Costruttore della classe astratta.
     * Viene chiamato quando creiamo un dipendente specifico.
     */
    public DipendenteAstratto(Long id, String nome, String cognome, int orario) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.orario = orario;
    }

    /**
     * Implementazione del metodo dell'interfaccia.
     * È ancora astratto perché la logica del calcolo non è comune a tutti.
     */
    @Override
    public abstract double calcolaStipendio();

    /**
     * Restituisce il nome completo (Nome + Cognome).
     * Questo è un metodo concreto: la logica è la stessa per tutti i dipendenti.
     */
    public String getNomeCompleto() {
        return nome + " " + cognome;
    }

    /**
     * Restituisce l'ID del dipendente.
     */
    public Long getId() {
        return id;
    }
}
