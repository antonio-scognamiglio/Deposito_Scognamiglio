package polimorfismo.es10;

import java.util.ArrayList;
import java.util.List;

import polimorfismo.es10.models.Auto;
import polimorfismo.es10.models.Moto;
import polimorfismo.es10.models.Veicolo;

public class Main {
    static void main(String[] args) {
        List<Veicolo> veicoli = new ArrayList<>();
        Auto auto = new Auto();
        auto.setMarca("Fiat");
        auto.setModello("Panda");
        veicoli.add(auto);
        Moto moto = new Moto();
        moto.setMarca("Honda");
        moto.setModello("CBR");
        veicoli.add(moto);
        for (Veicolo veicolo : veicoli) {
            veicolo.accendi();
            veicolo.descrizione();
        }
    }
}