package es13.generics;

public class GenericsMain {

    public static void main(String[] args) {
        Integer num = 444;
        GenClass<Integer> iObj = new GenClass<>(num);
        iObj.showType();
        int numericValue = (int) iObj.getObj();
        // Integer numeroWrapper = 9;
        // int numero = (int) numeroWrapper;
        System.out.println("Numeric Value: " + numericValue);

        String str = "Pippo";
        GenClass<String> sObj = new GenClass<>(str);
        sObj.showType();
        String stringValue = sObj.getObj();
        System.out.println("String value: " + stringValue);
    }

}
