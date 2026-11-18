package EserciziObserver.facile;

import java.util.function.Consumer;

class DisplayObserver implements Consumer<Double> {

    @Override
    public void accept(Double t) {
        System.out.println("Il display mostra: " + t + "°");
    }

}