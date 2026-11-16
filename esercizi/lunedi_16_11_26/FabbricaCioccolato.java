package lunedi_16_11_26;

import lunedi_16_11_26.models.Cioccolatino;
import lunedi_16_11_26.models.Fabbrica;

public class FabbricaCioccolato {
    public static void main(String[] args) {
        // Creiamo la fabbrica
        Fabbrica fabbrica = new Fabbrica();
        // Controlliamo lo stato iniziale della fabbrica
        fabbrica.printStatus();

        // Creiamo un cioccolato
        Cioccolatino cioccolatino = new Cioccolatino("cuore", "nocciola", 70.0, "fondente");
        // Produciamo il cioccolato
        fabbrica.produce(10, cioccolatino);
        // Controlliamo lo stato della fabbrica dopo la produzione
        fabbrica.printStatus();
    }
}
