package EserciziObserver.medio.observer;

import EserciziObserver.medio.event.IngressoSocio;

//Questa volta abbiamo preferito creare il nostro Observer invece si usare Consumer, ci dà più flessibilità e aggiunge una semantica più chiara, invece di fare il generico metodo accept, qui diciamo update, scegliamo noi come si deve chiamare il metodo
@FunctionalInterface
public interface Observer {
    void update(IngressoSocio evento);
}
