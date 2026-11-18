package EserciziObserver.medio.observer;

import EserciziObserver.medio.event.IngressoSocio;

public class ReceptionObserver implements Observer {

    @Override
    public void update(IngressoSocio evento) {
        if (evento.abbonamentoScaduto()) {
            System.out.println("Comunicazione della Reception: L'abbonamento è scaduto");
        }
    }

}
