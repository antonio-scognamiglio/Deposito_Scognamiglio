package order.boot.command;

import lombok.Setter;
import order.boot.service.OrdersService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class DeleteOrderCommand {
    private final OrdersService ordersService;
    @Setter
    private long id;

    public DeleteOrderCommand(OrdersService ordersService) {
        super();
        this.ordersService = ordersService;
    }

    public void execute() {
        ordersService.deleteOrderById(id);
    }
}
