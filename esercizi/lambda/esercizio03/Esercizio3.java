package esercizio03;

import java.util.List;
import java.util.Optional;

public class Esercizio3 {
    public record Ordine(String cliente, String prodotto, int quantita, double prezzoUnitario) {
        double totale() {
            return quantita * prezzoUnitario;
        }
    }

    public static void main(String[] args) {
        // Esercizio 3
        // i nomi dei prodotti senza doppioni, in ordine alfabetico;
        List<Ordine> ordini = List.of(
                new Ordine("Anna", "Mouse", 2, 25.0),
                new Ordine("Luca", "Monitor", 1, 199.0),
                new Ordine("Anna", "Tastiera", 1, 45.0),
                new Ordine("Marta", "Mouse", 3, 25.0),
                new Ordine("Luca", "Webcam", 2, 60.0),
                new Ordine("Paolo", "Monitor", 2, 199.0));
        List<String> nomiProdottiNoDuplicati = ordini.stream().map(e -> e.prodotto).distinct().sorted().toList();
        System.out.println("***************** Lista prodotti ordinati e senza duplicati*****************");
        nomiProdottiNoDuplicati.forEach(System.out::println);
        // il totale incassato (somma dei totale() di tutti gli ordini);
        double sommaTotali = ordini.stream().map(e -> e.totale()).reduce(0.0, (a, b) -> a + b);
        System.out.println("****Somma totale****\n" + sommaTotali);
        // i clienti con almeno un ordine da più di 100 euro, senza doppioni e in ordine
        // alfabetico;
        List<String> clientiFiltrati = ordini.stream().filter(e -> e.totale() > 100).map(e -> e.cliente).distinct()
                .sorted().toList();
        System.out.println("****Clienti con ordini da più di 100****\n" + clientiFiltrati);

        // L'ordine con il totale più alto, come testo cliente - prodotto.
        Optional<Ordine> ordineMax = ordini.stream()
                .max((x, y) -> Double.compare(x.totale(), y.totale()));
        if (ordineMax.isPresent()) {
            System.out.println("****Ordine con totale più alto****\n" + ordineMax.get().cliente + " - " + ordineMax.get().prodotto);
        } else {
            System.out.println("Nessun ordine presente");
        }
    }
}
