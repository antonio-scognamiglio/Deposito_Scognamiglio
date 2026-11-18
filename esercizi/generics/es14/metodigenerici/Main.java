package generics.es14.metodigenerici;

public class Main {
    public static void main(String[] args) {
        /*
         * String[] sArr = {"ciao","hello","cane","gatto","alberto"};
         * Double[] dArr = {1.1,1.2,1.3,1.4};
         * MetodiUtili mUtili = new MetodiUtili();
         * String puntoMedioString = mUtili.<String>getPuntoMedio(sArr);
         * String puntoPrimoString = mUtili.<String>getPrimo(sArr);
         * double puntoMedioDouble = MetodiUtili.<Double>getPuntoMedio(dArr);
         * double puntoPrimoDouble = MetodiUtili.<Double>getPrimo(dArr);
         * 
         * 
         * 
         * System.out.println("punto medio stringa: "+puntoMedioString);
         * System.out.println("punto primo stringa: "+puntoPrimoString);
         * System.out.println("punto medio double: "+puntoMedioDouble);
         * System.out.println("punto medio double: "+puntoPrimoDouble);
         */

        InstanzaMetodoGenerico<Integer> obj = new InstanzaMetodoGenerico<>(444);
        obj.<String>showA("friends");

    }
}
