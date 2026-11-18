package esercizio_collection;

import java.util.ArrayList;
import java.util.Arrays;

public class EsercizioMedioCollection {
    public static void main(String[] args) {
        ArrayList<String> playList = new ArrayList<>(Arrays.asList("Intro", "Groove", "Ballad", "Finale"));
        playList.remove(2);
        playList.addLast("Sorpresa");

        System.out.println("La mia playlist " + playList + "e contiente " + playList.size() + " brani");
    }
}
