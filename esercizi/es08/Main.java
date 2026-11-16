package es08;

import java.math.BigDecimal;

import es08.models.Prodotto;

public class Main {

    static void main(String[] args) {
        Prodotto prodotto1 = new Prodotto("Acqua");
        Prodotto prodotto2 = new Prodotto("Coca Cola");
        Prodotto prodotto3 = new Prodotto("Vino");
        Prodotto prodotto4 = new Prodotto("Bibita");
        Prodotto prodotto5 = new Prodotto("Birra");

        prodotto1.setPrezzo(new BigDecimal(1));
        prodotto2.setPrezzo(new BigDecimal(99));
        prodotto3.setPrezzo(new BigDecimal(5));
        prodotto4.setPrezzo(new BigDecimal(9.9));
        prodotto5.setPrezzo(new BigDecimal(10));

        System.out.println(prodotto1.getNome() + " " + prodotto1.getPrezzo());
        System.out.println(prodotto2.getNome() + " " + prodotto2.getPrezzo());
        System.out.println(prodotto3.getNome() + " " + prodotto3.getPrezzo());
        System.out.println(prodotto4.getNome() + " " + prodotto4.getPrezzo());
        System.out.println(prodotto5.getNome() + " " + prodotto5.getPrezzo());
    }
}
