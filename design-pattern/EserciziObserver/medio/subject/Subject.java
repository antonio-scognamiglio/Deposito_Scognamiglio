package EserciziObserver.medio.subject;

import EserciziObserver.medio.event.IngressoSocio;
import EserciziObserver.medio.observer.Observer;

interface Subject {
    // Mi sa che bisogna passare qualcosa dentro, altrimenti che aggiungo?
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(IngressoSocio evento);

}
