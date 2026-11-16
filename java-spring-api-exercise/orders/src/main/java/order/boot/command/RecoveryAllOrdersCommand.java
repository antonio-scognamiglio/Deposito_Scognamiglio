package order.boot.command;

import order.boot.service.OrdersService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import order.boot.model.response.OrderResponse;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RecoveryAllOrdersCommand {
    private final OrdersService ordersService;

    public RecoveryAllOrdersCommand(OrdersService ordersService) {
        super();
        this.ordersService = ordersService;
    }

    public List<OrderResponse> execute() {
        return ordersService.getAllOrders();
    }
}
