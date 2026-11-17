package EserciziFactory.facile;

/* 
Obiettivo: scrivere una simple factory con switch che restituisce oggetti diversi.

Consegna: scrivi un'interfaccia Veicolo con il metodo int ruote(). Crea le classi Auto (4 ruote) e Moto (2 ruote). Scrivi una classe VeicoloFactory con il metodo crea(String tipo) che restituisce il veicolo giusto e lancia un'eccezione per i tipi sconosciuti. Crea un'auto e una moto e stampa il numero di ruote di ciascuna.
 */

interface Veicolo {
    int ruote();

    String descrizione();
}

class Auto implements Veicolo {
    @Override
    public int ruote() {
        return 4;
    }

    public String descrizione() {

        return "Auto";
    }
}

class Moto implements Veicolo {
    @Override
    public int ruote() {
        return 2;
    }

    public String descrizione() {

        return "Moto";
    }
}

class VeicoloFactory {
    static Veicolo crea(String tipo) {
        // Switch expression (Java 14+): a differenza dello switch classico (blocco di
        // istruzioni con break), qui ogni ramo usa "->" e produce direttamente un
        // valore, quindi può stare dopo "return".
        return switch (tipo) {
            case "auto" -> new Auto();
            case "moto" -> new Moto();
            default -> throw new IllegalArgumentException("Veicolo sconosciuto: " + tipo);
        };
    }
}

public class FactoryFacile {
    public static void main(String[] args) {
        Veicolo v1 = VeicoloFactory.crea("auto");
        Veicolo v2 = VeicoloFactory.crea("moto");
        System.out.println("Descrizione: " + v1.descrizione() + " Numero di ruote: " + v1.ruote());
        System.out.println("Descrizione: " + v2.descrizione() + " Numero di ruote: " + v2.ruote());

    }

}
