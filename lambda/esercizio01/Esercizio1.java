package esercizio01;

import java.util.Arrays;
import java.util.List;

public class Esercizio1 {
    public static void main(String[] args) {
        List<Integer> numeri = List.of(1, 2, 3);
        System.out.println("Numeri moltiplicati per 2:");
        numeri.forEach(n -> System.out.println(n * 2));

        String[] parole = { "mondo", "a", "ciao" };
        Arrays.sort(parole, (x, y) -> x.length() - y.length());
        System.out.println("Parole ordinate per lunghezza:");
        System.out.println(Arrays.toString(parole));
    }
}