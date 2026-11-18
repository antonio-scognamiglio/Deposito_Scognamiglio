package EserciziStrategy.mediocontesto;

/* 
Obiettivo: usare il pattern Strategy "vero": un contesto che tiene una strategia e la cambia a runtime con un setter.

Consegna: scrivi un'interfaccia Tariffa con il metodo double applica(int ore). Crea due strategie (oraria, giornaliera). Scrivi una classe Contexto che tiene una Tariffa, ha un setter per cambiarla a runtime, e un metodo applica che delega alla strategia montata. Cambia la strategia a runtime e stampa i risultati.
 */

interface Tariffa {
    double applica(int ore);
}

class TariffaOraria implements Tariffa {
    @Override
    public double applica(int ore) {
        return ore * 2.0;
    }
}

class TariffaGiornaliera implements Tariffa {
    @Override
    public double applica(int ore) {
        // Arrotondo per eccesso, se scatta anche un'ora dalle 24 devi pagare 2 giorni
        int giorni = Math.ceilDiv(ore, 24);
        return giorni * 10;
    }
}

// Il contesto: tiene la strategia e delega l'esecuzione.
// Questo è il cuore del pattern Strategy: il comportamento cambia a runtime
// montando strategie diverse, senza cambiare chi chiama applica().
class Contexto {
    private Tariffa tariffa;

    public void setTariffa(Tariffa t) {
        this.tariffa = t;  // ← cambio a runtime
    }

    public double applica(int ore) {
        return tariffa.applica(ore);  // ← delega alla strategia montata
    }
}

public class StrategyMedioContesto {
    public static void main(String[] args) {
        Contexto ctx = new Contexto();

        // Monto la tariffa oraria
        ctx.setTariffa(new TariffaOraria());
        System.out.println("5 ore, tariffa oraria: " + ctx.applica(5));

        // Cambio a runtime: monto la giornaliera
        ctx.setTariffa(new TariffaGiornaliera());
        System.out.println("25 ore, tariffa giornaliera: " + ctx.applica(25));

        // Cambio ancora: torno all'oraria
        ctx.setTariffa(new TariffaOraria());
        System.out.println("25 ore, tariffa oraria: " + ctx.applica(25));
    }
}
