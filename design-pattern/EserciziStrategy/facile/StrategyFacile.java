package EserciziStrategy.facile;

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

public class StrategyFacile {
    public static void main(String[] args) {
        Tariffa tariffaOraria = new TariffaOraria();
        Tariffa tariffaGiornaliera = new TariffaGiornaliera();

        System.out.println("Costo di 5 ore con tariffa giornaliera " + tariffaGiornaliera.applica(5));
        System.out.println("Costo di 5 ore con tariffa oraria " + tariffaOraria.applica(5));
        System.out.println("Costo di 25 ore con tariffa giornaliera " + tariffaGiornaliera.applica(25));
        System.out.println("Costo di 25 ore con tariffa oraria " + tariffaOraria.applica(25));

    }
}
