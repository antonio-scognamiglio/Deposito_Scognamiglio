package polimorfismo.es02.dipendenti;

import java.util.ArrayList;

import polimorfismo.es02.dipendenti.models.*;

/**
 * Classe principale che avvia l'applicazione.
 * Dimostra il concetto di Polimorfismo gestendo diversi tipi di dipendenti
 * all'interno di una singola lista.
 */
public class Main {
    public static void main(String[] args) {
        // Creiamo una lista di tipo "DipendenteAstratto".
        // Questo ci permette di inserire sia FullTime che PartTime nella stessa lista.
        ArrayList<DipendenteAstratto> lista = new ArrayList<>();

        // Popoliamo la lista con diversi oggetti
        // Nota: anche se aggiungiamo classi diverse, Java le vede tutte come
        // "DipendenteAstratto"
        lista.add(new DipendenteFullTime(1L, "Mario", "Rossi", 40, 3000.0));
        lista.add(new DipendentePartTime(2L, "Luigi", "Bianchi", 20, 15.0));
        lista.add(new DipendenteFullTime(3L, "Anna", "Verdi", 40, 2800.0));
        lista.add(new DipendentePartTime(4L, "Giulia", "Neri", 15, 20.0));

        // Stampiamo l'elenco dei dipendenti
        System.out.println("--- Elenco Dipendenti ---");
        // Ciclo for-each: scorre ogni elemento della lista
        for (DipendenteAstratto d : lista) {
            // Qui avviene il Polimorfismo:
            // d.calcolaStipendio() eseguirà il calcolo corretto (totale o moltiplicazione)
            // in base all'oggetto reale contenuto nella variabile 'd'.
            System.out.println(d.getNomeCompleto() + " - Stipendio: " + d.calcolaStipendio());
        }
    }
}
