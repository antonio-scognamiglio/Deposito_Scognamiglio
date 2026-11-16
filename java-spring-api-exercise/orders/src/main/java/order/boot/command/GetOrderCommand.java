package order.boot.command;
import java.util.Objects;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import order.boot.model.response.OrderResponse;
import order.boot.service.OrdersService;

/**
 * Questa classe rappresenta un "Command" nel pattern CQRS (Command Query
 * Responsibility Segregation).
 * Il suo scopo specifico è gestire l'azione di recupero di un ordine tramite il
 * suo ID.
 */
@Component
/*
 * Definiamo lo scope come SCOPE_PROTOTYPE.
 * Questo è fondamentale per i Command Object: assicura che ogni volta che viene
 * richiesto
 * questo bean, Spring ne crei una nuova istanza. In questo modo, ogni richiesta
 * (con il suo
 * ID specifico) avrà il proprio oggetto isolato, evitando problemi di
 * concorrenza.
 */
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GetOrderCommand {

    // Servizio finale (immutabile) per gestire le operazioni sugli ordini
    private final OrdersService ordersService;

    // L'identificativo univoco dell'ordine da recuperare
    private Long id;

    /**
     * Costruttore per l'iniezione della dipendenza OrdersService.
     * 
     * @param ordersService il servizio fornito dal contenitore Spring.
     */
    public GetOrderCommand(OrdersService ordersService) {
        super();
        this.ordersService = ordersService;
    }

    /**
     * Imposta l'ID dell'ordine desiderato.
     * 
     * @param id l'ID dell'ordine.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Esegue l'azione principale del comando.
     * 
     * @return un oggetto OrderResponse contenente i dettagli dell'ordine trovato.
     */
    public OrderResponse execute() {
        // Chiama il servizio passando l'ID impostato tramite il metodo setId
        return ordersService.getOrderById(Objects.requireNonNull(id, "Order ID must not be null"));
    }
}