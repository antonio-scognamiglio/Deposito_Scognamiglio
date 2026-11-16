package es20.foreach;

import java.util.Arrays;
import java.util.List;

public class ForEachLambda {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        intList.forEach(n -> System.out.println(n));
    }
}
