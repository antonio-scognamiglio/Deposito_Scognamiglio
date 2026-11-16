package es15.stampatutto;

public class StampaTutto {

    public static <E> void printArray(E[] arr) {

        for (E ele : arr) {

            System.out.printf("%s ", ele);
        }
        System.out.println("\n*******************************");

        for (int i = 0; i < arr.length; ++i) {

            System.out.printf("%s ", arr[i]);
        }
    }
}
