package esercizio02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Esercizio2 {

    public static void main(String[] args) {
        List<String> frutta = new ArrayList<>(
                List.of("kiwi", "banana", "mela", "ananas", "pera", "fico", "arancia"));
        // Scrivi un Consumer<String> stampa che stampa la parola, e usalo con forEach
        // per mostrare la lista iniziale.
        Consumer<String> stampa = (p -> System.out.println(p));
        System.out.println("*****************Lista parole*****************");
        frutta.forEach(stampa);
        // Scrivi un Predicate<String> corta vera per le parole con 4 o meno caratteri,
        // e usalo con removeIf.
        Predicate<String> corta = p -> p.length() <= 4;
        System.out.println("*****************Lista parole più lunghe di 4*****************");
        frutta.removeIf(corta);
        frutta.forEach(stampa);

        // Ordina la lista con un Comparator<String>: prima le parole più lunghe, e a
        // parità di lunghezza in ordine alfabetico.
        // Il compare è un metodo dell'istanza, nel nostro caso x è un'istanza di String
        // e usiamo un suo metodo
        Comparator<String> ordineDoppio = (x, y) -> {
            if (x.length() == y.length()) {
                // Se la lunghezza è uguale ordine alfabetico
                return x.compareTo(y);
            } else {
                // altrimenti ordine di lunghezza
                return y.length() - x.length();
            }
        };

        /*
         * Alternativa che usa un metodo statico dell'interfaccia Comparator
         * Comparator<String> ordineDoppio =
         * Comparator.comparingInt(String::length).reversed()
         * .thenComparing(Comparator.naturalOrder());
         */
        frutta.sort(ordineDoppio);

        // Stampa di nuovo la lista con lo stesso Consumer, dopo una riga ---.
        System.out.println("*****************Lista parole ordinata*****************");
        frutta.forEach(stampa);

    }
}
