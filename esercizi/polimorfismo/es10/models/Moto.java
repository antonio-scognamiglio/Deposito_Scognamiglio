package polimorfismo.es10.models;

public class Moto extends Veicolo {
    public void impenna() {
        System.out.println("La " + modello + " della " + marca + " è in posizione impennata.");
    }

    @Override
    public void descrizione() {
        System.out.println("Tipo di veicolo: Moto" + ", Marca: " + marca + ", Modello: " + modello);
    }
}
