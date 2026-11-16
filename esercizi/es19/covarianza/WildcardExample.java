package es19.covarianza;

import java.util.ArrayList;
import java.util.List;

public class WildcardExample {
    public static void main(String[] args) {
        List<? extends Number> numbers = new ArrayList<>(List.of(10));
        List<? super Integer> integers = new ArrayList<Number>();

        // Covarianza (? extends): read-only, posso leggere ma non aggiungere
        Number number = numbers.get(0);

        // Controvarianza (? super): posso aggiungere valori del bound (Integer)
        integers.add(42);

        System.out.println("numbers[0] = " + number);
        System.out.println("integers dopo add: " + integers);
    }
}
