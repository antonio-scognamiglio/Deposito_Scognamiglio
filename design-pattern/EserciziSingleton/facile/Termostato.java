package EserciziSingleton.facile;

public class Termostato {
    // Costruttore vuoto privato, nessuno può usarlo
    private Termostato() {
    }

    /*
     * istanza della classe statica non modificabile, noi scegliamo private in
     * questo modo passiamo per il getter, potrebbe essere utile se ci fossero delle
     * logiche come la lazyInitialization, invece con l'Enum non abbiamo scelta
     * l'api usa public static final per questo non abbiamo un getter nell'enum
     * usato come singleton
     */
    private static final Termostato INSTANCE = new Termostato();

    // privata per non consentire l'acceso all'esterno se non tramite getter o
    // setter
    private double temperatura = 20.0;

    // Metodo statico che restituisce l'istanza unica
    static Termostato getInstance() {
        return INSTANCE;
    }

    // getter
    double getTemperatura() {
        return temperatura;
    }

    // setter
    void setTemperatura(double val) {
        this.temperatura = val;
    }

}
