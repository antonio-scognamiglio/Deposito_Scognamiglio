package EserciziObserver.medio.observer;

import EserciziObserver.medio.event.IngressoSocio;

public class LogObserver implements Observer {

    @Override
    public void update(IngressoSocio evento) {
        System.out.println(
                "****Ingresso****\n" + "Nome: " + evento.nome() + "\nAbbonamento: " + evento.abbonamentoScaduto());
    }
}
