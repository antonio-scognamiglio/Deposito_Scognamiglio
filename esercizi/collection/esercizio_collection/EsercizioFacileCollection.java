package esercizio_collection;

public class EsercizioFacileCollection {
    public static void main(String[] args) {
        double[] temperature = { 12.5, 15.0, 9.8, 18.2, 14.0, 11.3, 16.7 };
        double max = Double.MIN_VALUE;
        int intDay = Integer.MIN_VALUE;
        for (int i = 0; i < temperature.length; i++) {
            double v = temperature[i];
            if (v > max) {
                max = v;
                intDay = i;
            }
        }
        String day = "";
        switch (intDay) {
            case 0:
                day = "Lunedi";
                break;
            case 1:
                day = "Martedì";
                break;
            case 2:
                day = "Mercoledì";
                break;
            case 3:
                day = "Giovedì";
                break;
            case 4:
                day = "Venerdì";
                break;
            case 5:
                day = "Sabato";
                break;
            case 6:
                day = "Domenica";
                break;
            default:
                day = "Giorno non trovato";
                break;

        }

        System.out.println("La temperatura maggiore è " + max + " registrata di " + day);
    }
}
