package es10.models;

public class Auto extends Veicolo {
    public void apriBagagliaio() {
        System.out.println("Il bagagliaio del " + modello + " è aperto.");
    }

    @Override
    public void descrizione() {
        System.out.println("Tipo di veicolo: Auto " + ", Marca: " + marca + ", Modello: " + modello);
    }
}
