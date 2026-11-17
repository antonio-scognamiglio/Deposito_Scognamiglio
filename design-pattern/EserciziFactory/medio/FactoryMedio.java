package EserciziFactory.medio;

import java.util.Map;
import java.util.function.Supplier;

/* 
Obiettivo: creare una factory che associa un comando testuale a un oggetto da eseguire.

Consegna: un mini terminale riceve comandi come "somma 2 3" oppure "moltiplica 4 5". Scrivi un'interfaccia Comando con il metodo String esegui(int a, int b). Crea una factory che, dato il nome del comando, restituisce l'implementazione corretta. Il comando "somma" restituisce la somma, "moltiplica" il prodotto. Per un nome sconosciuto la factory deve restituire un Optional vuoto, non lanciare un'eccezione.
 */

interface Comando {
    String esegui(int a, int b);
}

record Somma() implements Comando {
    public String esegui(int a, int b) {
        return String.valueOf(a + b);
    };
}

record Moltiplicazione() implements Comando {
    public String esegui(int a, int b) {
        return String.valueOf(a * b);
    }
}

class ComandoFactory {
    // Supplier<T> è una functional interface: un solo metodo astratto "T get()".
    // È una convenzione standard di java.util.function, nulla di particolare.
    // Si implementa con una lambda o con un method reference.
    private static final Map<String, Supplier<Comando>> FABBRICHE = Map.of(
            // Una chiave → un Supplier: la lambda e il method reference sono
            // due modi equivalenti di implementare get().
            "somma", () -> new Somma(), "moltiplicazione", Moltiplicazione::new);

    static Comando crea(String tipo) {
        // Recupera il Supplier associato alla chiave; null se sconosciuta.
        Supplier<Comando> fabbrica = FABBRICHE.get(tipo);
        if (fabbrica == null) {
            throw new IllegalArgumentException("Tipo sconosciuto: " + tipo);
        }
        // Invoca get() per produrre l'istanza di Comando.
        return fabbrica.get();
    }
}

public class FactoryMedio {
    public static void main(String[] args) {
        Comando cmdSomma = ComandoFactory.crea("somma");
        Comando cmdMoltiplicazione = ComandoFactory.crea("moltiplicazione");
        System.out.println("Risultato esecuzione comando somma: " + cmdSomma.esegui(99, 33));
        System.out.println("Risultato esecuzione comando moltiplicazione: " + cmdMoltiplicazione.esegui(99, 33));
    }

}
