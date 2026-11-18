package classi.es09;

import classi.es09.models.Auto;
import classi.es09.models.Moto;

public class Main {
    static void main(String[] args) {
        Auto auto = new Auto();
        auto.setMarca("Fiat");
        auto.setModello("Panda");
        auto.accendi();
        auto.apriBagagliaio();

        Moto moto = new Moto();
        moto.setMarca("Ducati");
        moto.setModello("Monster");
        moto.accendi();
        moto.impenna();
    }
}
