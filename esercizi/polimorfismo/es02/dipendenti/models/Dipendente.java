package polimorfismo.es02.dipendenti.models;

/**
 * Interfaccia Dipendente: rappresenta il "contratto" base.
 * Ogni tipo di dipendente, che sia a tempo pieno o parziale,
 * DEVE avere un metodo per calcolare lo stipendio.
 */
public interface Dipendente {
    /**
     * Restituisce lo stipendio calcolato del dipendente.
     * Questo metodo è astratto perché ogni tipo di dipendente
     * ha una logica di calcolo diversa.
     */
    double calcolaStipendio();
}
