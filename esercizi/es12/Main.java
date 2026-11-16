package es12;

import es12.models.Dipendente;
import es12.models.Impiegato;
import es12.models.Manager;

public class Main {
    static void main(String[] args) {
        Dipendente imp = new Impiegato("Mario", "Rossi", 3000);
        imp.mostraDati();

        Dipendente man = new Manager("Anna", "Bianchi", 5000);
        man.mostraDati();
    }
}
