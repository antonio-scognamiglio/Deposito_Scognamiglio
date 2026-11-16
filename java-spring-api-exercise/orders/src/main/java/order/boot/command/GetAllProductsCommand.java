package order.boot.command;

import java.util.List;

import order.boot.service.OrderProductsService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import order.boot.dto.ProductsResponseDto;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GetAllProductsCommand {

    private final OrderProductsService orderProductsService;

    public GetAllProductsCommand(OrderProductsService orderProductsService) {
        super();
        this.orderProductsService = orderProductsService;
    }

    public List<ProductsResponseDto> execute()
    {
        return orderProductsService.findAllProduct();
    }
}