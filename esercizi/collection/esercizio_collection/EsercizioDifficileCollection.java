package esercizio_collection;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class EsercizioDifficileCollection {
    public static void main(String[] args) {
        // LinkedHashMap: serve per preservare l'ordine di arrivo
        LinkedHashMap<String, Double> incassiArrivo = new LinkedHashMap<>();

        // TreeMap: serve per preservare l'ordine alfabetico
        TreeMap<String, Double> incassiAlfabetico = new TreeMap<>();

        // Inserisco gli incassi nell'ordine di arrivo
        incassiArrivo.put("Inception", 836.9);
        incassiArrivo.put("Interstellar", 701.5);
        incassiArrivo.put("The Matrix", 463.4);
        incassiArrivo.put("Dune", 827.6);

        // copio tutto il LinkedHashMap in TreeMap poi si occuperà lui di ordinare i
        // dati
        incassiAlfabetico.putAll(incassiArrivo);

        System.out.println("Ordine di arrivo:");
        incassiArrivo.forEach((titolo, incasso) -> System.out.printf("  %s: %.1f%n", titolo, incasso));

        System.out.println("\nOrdine alfabetico:");
        incassiAlfabetico.forEach((titolo, incasso) -> System.out.printf("  %s: %.1f%n", titolo, incasso));
    }
}