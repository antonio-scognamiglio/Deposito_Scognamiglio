package EserciziObserver.medio.subject;

import java.util.ArrayList;
import java.util.List;

import EserciziObserver.medio.event.IngressoSocio;
import EserciziObserver.medio.observer.Observer;

public class Palestra implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    // Chi usa questa funzione non sa com'è strutturato un evento mette i dati
    // grezzi, infatti dal main facciamo così se ne occupa il Subject di creare
    // l'oggetto Evento
    public void registraIngresso(String nome, boolean abbonamentoScaduto) {
        notifyObservers(new IngressoSocio(nome, abbonamentoScaduto));
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(IngressoSocio evento) {

        observers.forEach(o -> o.update(evento));
    }

}
