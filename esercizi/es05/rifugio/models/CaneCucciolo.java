package es05.rifugio.models;

public class CaneCucciolo extends Cane {
    private int livelloVivacita;

    public CaneCucciolo(String nome, String razza, int eta, int livelloVivacita) {
        super(nome, razza, eta);
        // Invece di scrivere l'IF qui, chiamiamo il metodo che lo contiene già!
        setLivelloVivacita(livelloVivacita);
    }

    public void setLivelloVivacita(int livelloVivacita) {
        if (livelloVivacita >= 1 && livelloVivacita <= 5) {
            this.livelloVivacita = livelloVivacita;
        } else {
            System.out.println("Errore: Livello non valido. Impostato valore di default.");
            this.livelloVivacita = 3; // Valore di default
        }
    }

    public int getLivelloVivacita() {
        return livelloVivacita;
    }

    @Override
    public String esciDallaGabbia() {
        return getNome() + "esce dalla gabbia saltando dalla gioia!";
    }

}
