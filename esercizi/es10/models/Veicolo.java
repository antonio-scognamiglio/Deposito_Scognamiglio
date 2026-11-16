package es10.models;

public class Veicolo {
    String marca;
    String modello;

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void accendi() {
        System.out.println("Il veicolo " + modello + " della " + marca + " è acceso.");
    }

    public void descrizione() {
        System.out.println("Veicolo di " + "Marca: " + marca + ", Modello: " + modello);
    }
}
