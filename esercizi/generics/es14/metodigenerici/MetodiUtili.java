package generics.es14.metodigenerici;

public class MetodiUtili {

    public MetodiUtili() {
        super();
    }

    public static <T> T getPuntoMedio(T[] arr) {
        return arr[arr.length / 2];
    }

    public static <T> T getPrimo(T[] arr) {
        return arr[0];
    }
}
