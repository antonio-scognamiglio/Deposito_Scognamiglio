package es02.dipendenti.models;

/**
 * Classe concreta DipendenteFullTime.
 * Eredita da DipendenteAstratto e aggiunge la specifica paga mensile.
 */
public class DipendenteFullTime extends DipendenteAstratto {
    // Attributo specifico per il dipendente a tempo pieno
    protected double pagaTotale;

    /**
     * Costruttore per il dipendente a tempo pieno.
     * 
     * @param id         Identificativo univoco
     * @param nome       Nome del dipendente
     * @param cognome    Cognome del dipendente
     * @param orario     Ore lavorate
     * @param pagaTotale Stipendio totale mensile
     */
    public DipendenteFullTime(Long id, String nome, String cognome, int orario, double pagaTotale) {
        // Passiamo i dati comuni alla classe padre
        super(id, nome, cognome, orario);
        // Impostiamo il dato specifico della classe figlia.
        this.pagaTotale = pagaTotale;
    }

    /**
     * Implementazione del calcolo stipendio.
     * Per il FullTime, lo stipendio è semplicemente la variabile pagaTotale.
     */
    @Override
    public double calcolaStipendio() {
        return this.pagaTotale;
    }
}
