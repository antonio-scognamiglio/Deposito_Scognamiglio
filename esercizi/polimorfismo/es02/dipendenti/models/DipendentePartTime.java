package polimorfismo.es02.dipendenti.models;

/**
 * Classe concreta DipendentePartTime.
 * Eredita da DipendenteAstratto e aggiunge la paga oraria.
 */
public class DipendentePartTime extends DipendenteAstratto {
    // Attributo specifico per il dipendente a tempo parziale
    protected double pagaOraria;

    /**
     * Costruttore per il dipendente a tempo parziale.
     * 
     * @param id         Identificativo univoco
     * @param nome       Nome del dipendente
     * @param cognome    Cognome del dipendente
     * @param orario     Ore lavorate
     * @param pagaOraria Tariffa paga per ogni ora di lavoro
     */
    public DipendentePartTime(Long id, String nome, String cognome, int orario, double pagaOraria) {
        // Passa i dati comuni alla classe padre
        super(id, nome, cognome, orario);
        // Imposta la paga oraria specifica
        this.pagaOraria = pagaOraria;
    }

    /**
     * Implementazione del calcolo stipendio.
     * Per il PartTime, lo stipendio è il prodotto tra paga oraria e ore lavorate.
     */
    @Override
    public double calcolaStipendio() {
        return pagaOraria * orario;
    }
}
