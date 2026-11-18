package classi.es06.gestione_personale_azienda;

import classi.es06.gestione_personale_azienda.models.Dipendente;
import classi.es06.gestione_personale_azienda.models.Manager;
import classi.es06.gestione_personale_azienda.models.Programmatore;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Dipendente> dipendenti = new ArrayList<>();

        // Inserimento Programmatore
        dipendenti.add(new Programmatore("Mario Rossi", "P001", 2500.0, "Java"));
        
        // Inserimento Manager
        Manager manager = new Manager("Anna Bianchi", "M001", 4000.0, 500.0);
        dipendenti.add(manager);

        // Azsegna progetti al manager (overloading)
        manager.assegnaProgetto("Sviluppo App");
        manager.assegnaProgetto("Migrazione DB", "Alta");

        // Ciclo per stampare nome e stipendio usando il polimorfismo
        System.out.println("--- Lista Dipendenti ---");
        for (Dipendente d : dipendenti) {
            System.out.println("Nome: " + d.getNome() + " | Stipendio: " + d.calcolaStipendio() + " €");
        }
        
        // Esempio di promozione per il manager (cast)
        if (dipendenti.get(1) instanceof Manager) {
            ((Manager) dipendenti.get(1)).riceviPromozione();
        }
    }
}
