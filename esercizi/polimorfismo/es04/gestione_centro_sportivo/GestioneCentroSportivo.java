package polimorfismo.es04.gestione_centro_sportivo;

import java.util.ArrayList;
import java.util.List;

import polimorfismo.es04.gestione_centro_sportivo.models.Prenotazione;
import polimorfismo.es04.gestione_centro_sportivo.models.PrenotazioneCampoAllAperto;
import polimorfismo.es04.gestione_centro_sportivo.models.PrenotazioneCampoCoperto;

public class GestioneCentroSportivo {
    public static void main(String[] args) {
        // Creazione della lista delle prenotazioni
        List<Prenotazione> prenotazioni = new ArrayList<>();

        // 1. Campi Coperti
        // Con riscaldamento (Tariffa base 20€/h + 15€ extra)
        prenotazioni.add(new PrenotazioneCampoCoperto("C1", "Mario Rossi", 2, 20.0, true));
        // Senza riscaldamento (Tariffa base 20€/h)
        prenotazioni.add(new PrenotazioneCampoCoperto("C2", "Luca Bianchi", 2, 20.0, false));

        // 2. Campi All'Aperto
        // Con casacche (Tariffa 1.50€/h * ore)
        prenotazioni.add(new PrenotazioneCampoAllAperto("A1", "Anna Verdi", 3, 15.0, true));
        // Senza casacche (Tariffa base 15€/h * ore)
        prenotazioni.add(new PrenotazioneCampoAllAperto("A2", "Giulia Neri", 3, 15.0, false));

        // Stampa dei risultati
        System.out.println("--- Riepilogo Prenotazioni ---");
        double incassoTotale = 0.0;
        for (Prenotazione p : prenotazioni) {
            double costo = p.calcolaCostoTotale();
            incassoTotale += costo;
            System.out.println(p.ottieniRiepilogo());
            System.out.println("Costo Totale: " + costo + "€");
            System.out.println("------------------------------");
        }
        System.out.println("INCASSO TOTALE GIORNALE: " + incassoTotale + "€");
    }
}
