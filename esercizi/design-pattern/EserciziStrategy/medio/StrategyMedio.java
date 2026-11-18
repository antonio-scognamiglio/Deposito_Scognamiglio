package EserciziStrategy.medio;

/* Obiettivo: usare una lista di strategie in Java puro, applicandole in sequenza.

Consegna: scrivi un'interfaccia Formattazione con il metodo String applica(String testo). Crea tre strategie: tutto maiuscolo, ogni parola con la prima lettera maiuscola, testo al contrario. Applica tutte e tre alla stessa frase, una dopo l'altra, e stampa ogni risultato su una riga. */

interface Formatter {
    String applica(String testo);
}

class Capitalize implements Formatter {

    @Override
    public String applica(String testo) {
        // Estraiamo le parole, supponendo che il separatore sia uno spazio vuoto
        String[] parole = testo.split(" ");
        for (String parola : parole) {
            parola = parola.substring(0, 1).toUpperCase() + parola.substring(1);
        }
        return String.join(" ", parole);
    }
}

class Reverse implements Formatter {

    @Override
    public String applica(String testo) {
        StringBuilder sb = new StringBuilder(testo);
        return sb.reverse().toString();
        /*
         * Oppure a mano
         * char[] arr = s.toCharArray();
         * 
         * String reverse = "";
         * for (int i = arr.length - 1; i >= 0; i--) {
         * reverse += arr[i];
         * }
         */
    }
}

class UpperCase implements Formatter {

    @Override
    public String applica(String testo) {
        return testo.toUpperCase();
    }

}

public class StrategyMedio {
    public static void main(String[] args) {
        String frase = "jensen huang si è dimesso da amministratore delegato di nvidia";
        Formatter uppercaseFormatter = new UpperCase();
        Formatter capitalizeFormatter = new Capitalize();
        Formatter reverseFormatter = new Reverse();

        System.out.println("*****UpperCased*****\n" + uppercaseFormatter.applica(frase));
        System.out.println("*****Capitalized*****\n" + capitalizeFormatter.applica(frase));
        System.out.println("*****Reversed*****\n" + reverseFormatter.applica(frase));

    }

}
