package EserciziObserver.facile;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/* 
Obiettivo: implementare un publisher con lista di osservatori in Java puro.
Consegna: una serra ha un termometro che, a ogni nuova lettura, avvisa due dispositivi: un ventilatore, che si accende sopra 28 gradi, e un display, che mostra sempre il valore. Scrivi la classe Termometro con iscrivi(...) e registra(double temperatura). Gli osservatori sono lambda. Registra tre letture: 25, 29 e 27 gradi.
 */
public class ThermometerSubject {
    private final List<Consumer<Double>> observers = new ArrayList<>();

    void subscribe(Consumer<Double> o) {
        observers.add(o);
    }

    void notify(Double temperatura) {
        for (Consumer<Double> o : observers) {
            o.accept(temperatura);
        }
    }
}
