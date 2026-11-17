package EserciziObserver.medio.main;

import EserciziObserver.medio.observer.LogObserver;
import EserciziObserver.medio.observer.Observer;
import EserciziObserver.medio.observer.ReceptionObserver;
import EserciziObserver.medio.subject.Palestra;

public class ObserverMedio {
    public static void main(String[] args) {
        Palestra palestra = new Palestra();
        Observer logObserver = new LogObserver();
        palestra.addObserver(logObserver);
        Observer receptionObserver = new ReceptionObserver();
        palestra.addObserver(receptionObserver);
        palestra.registraIngresso("Diego", false);
        palestra.registraIngresso("Roberto", true);
        palestra.registraIngresso("Nicola", false);
        palestra.removeObserver(receptionObserver);
        palestra.registraIngresso("Gianfranco", true);
    }

}
