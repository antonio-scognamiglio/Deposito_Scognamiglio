package classi.es12;

import classi.es12.models.Dipendente;
import classi.es12.models.Impiegato;
import classi.es12.models.Manager;

public class Main {
    static void main(String[] args) {
        Dipendente imp = new Impiegato("Mario", "Rossi", 3000);
        imp.mostraDati();

        Dipendente man = new Manager("Anna", "Bianchi", 5000);
        man.mostraDati();
    }
}
