package polimorfismo.es05.rifugio;

import polimorfismo.es05.rifugio.models.Cane;
import polimorfismo.es05.rifugio.models.CaneCucciolo;
import polimorfismo.es05.rifugio.models.CaneAnziano;

public class Rifugio {
    public static void main(String[] args) {
        // 1. Creazione dell'array di tipo Cane (Dimensione 4)
        // Grazie al polimorfismo, questo array può contenere qualsiasi sottoclasse di
        // Cane
        Cane[] listaCani = new Cane[4];

        // 2. Popolamento dell'array con istanze diverse
        // Nota come usiamo i costruttori specifici delle sottoclassi
        listaCani[0] = new CaneCucciolo("Fido", "Pastore Tedesco", 2, 5);
        listaCani[1] = new CaneAnziano("Luna", "Golden Retriever", 12, true);
        listaCani[2] = new CaneCucciolo("Toro", " Bulldog", 1, 4);
        listaCani[3] = new CaneAnziano("Bello", "Labrador", 10, false);

        System.out.println("--- Inizio della simulazione di liberazione ---");
        System.out.println();

        // 3. Simulazione della liberazione (Ciclo for-each)
        for (Cane cane : listaCani) {
            System.out.println(cane.esciDallaGabbia());
        }

        System.out.println();
        System.out.println("--- Simulazione completata ---");
    }
}
