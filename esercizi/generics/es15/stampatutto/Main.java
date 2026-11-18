package generics.es15.stampatutto;

public class Main {

    public static void main(String[] args) {

        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 1.2, 1.3 };
        Character[] charArray = { 'h', 'e', 'l', 'l', 'o' };

        System.out.println("\nInt array contains: ");
        StampaTutto.printArray(intArray);

        System.out.println("\nDouble array contains: ");
        StampaTutto.printArray(doubleArray);

        System.out.println("\nChar array contains: ");
        StampaTutto.printArray(charArray);
    }
}
