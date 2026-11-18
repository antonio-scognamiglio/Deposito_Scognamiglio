package generics.es17.stats;

public class StatsMain {

    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4 };
        Float[] floatArray = { 1.0F, 2.0F, 3.0F, 4.0F };
        Double[] doubleArray = { 1.0, 2.0, 3.0, 4.0 };

        // Conversione array di int in array di Integer
        // Integer[] integerArray =
        // Arrays.stream(intArray).boxed().toArray(Integer[]::new);
        // Conversione array di Integere in array di Int
        // int[] integerArray =
        // Arrays.stream(intArray).mapToInt(Integer::intValue).toArray();

        Stats<Integer> intStats = new Stats<>(intArray);
        Stats<Float> floatStats = new Stats<>(floatArray);
        Stats<Double> doubleStats = new Stats<>(doubleArray);

        System.out.println("Media interi: " + intStats.average());
        System.out.println("Media float: " + floatStats.average());
        System.out.println("Media double: " + doubleStats.average());
    }
}
