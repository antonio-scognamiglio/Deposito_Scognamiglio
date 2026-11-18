package classi.es09.models;

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
        System.out.println("Il " + modello + " della " + marca + " è acceso.");
    }
}
