package order.boot.tools;

import java.math.BigDecimal;
import java.util.List;

import order.boot.model.response.OrderResponse;
import order.boot.service.OrdersService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class OrderToolAI {

    private final OrdersService ordersService;

    public OrderToolAI(OrdersService ordersService) {
        super();
        this.ordersService = ordersService;
    }

    @Tool(description = "Recupera tutti gli ordini presenti in tabella")
    public List<OrderResponse> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @Tool(description = "Recupera un ordine specifico per il suo id")
    public OrderResponse getOrderById(Long id) {
        return ordersService.getOrderById(id);
    }

    @Tool(description = "Crea un nuovo ordine con i prodotti e il totale specificati")
    public OrderResponse createOrder(BigDecimal total, String products) {
        return ordersService.saveNewOrder(total, products);
    }
}
