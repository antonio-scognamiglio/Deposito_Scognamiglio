package EserciziSingleton.medio;

/* 
A differenza di altri linguaggi in Java, l'enum è una classe, non un semplice insieme di valori fissi
Sotto il cofano, il compilatore genera qualcosa come:
public class DistributoreBevande extends Enum<DistributoreBevande> {
    public static final DistributoreBevande INSTANCE = new DistributoreBevande();

        private DistributoreBevande() { }
} 
Ed è questo il motivo per cui può avere variabili e metodi, il costruttore è generato automaticamente ed è privato, si potrebbe anche scrivere ma è inutile.
Ogni costante di un enum è una sua propria istanza (un oggetto). Se hai più
valori, sono tante istanze distinte. 
*/
public enum DistributoreBevande {
    INSTANCE;

    private double credito = 0.0;

    /*
     * Se avessimo usato la concorrenza, quindi il multithread sarebbe stato
     * necessario aggiungere davanti ai metodi che mutano lo stato synchronized, ma
     * in questo esempio non abbiamo creato dei thread (new Thread (...)) quindi è
     * tutto single thread, se avessimo lavorato con più thread, con synchronized
     * avremmo potuto proteggere le mutazioni dello stato da race condition
     */
    void inserisci(double val) {
        if (val >= 0) {
            credito += val;
        } else {
            System.out.println("********\n" + "Impossibile Inserire: " + val + " non è un valore valido");
        }
    }

    boolean eroga(double prezzo) {
        if (prezzo <= this.credito) {
            credito -= prezzo;
            return true;
        }
        return false;
    }

    void leggiCreditoDistributore() {
        System.out.println("********\n" + "Il credito del distributore è: " + credito);
    }
}
