package order.boot.command;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Setter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import order.boot.dto.ProductsResponseDto;
import order.boot.model.request.OrderRequestModel;
import order.boot.model.response.InformationOrderResponse;
import order.boot.model.response.OrderProductResponse;
import order.boot.model.response.OrderResponse;
import order.boot.service.OrdersService;
import order.boot.service.OrderProductsService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AddOrderCommand {

	private final OrdersService ordersService;
	private final OrderProductsService orderProductsService;
	@Setter
    private OrderRequestModel orderRequestModel;

    public AddOrderCommand(OrdersService ordersService, OrderProductsService orderProductsService) {
		super();
		this.ordersService = ordersService;
		this.orderProductsService = orderProductsService;
	}

	public List<InformationOrderResponse> execute() {
		List<ProductsResponseDto> lsProductOrder = orderProductsService.findProductsById(orderRequestModel);

		BigDecimal totale = lsProductOrder.stream()
				.map(map -> map.price().multiply(BigDecimal.valueOf(map.amount())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		OrderResponse orderSaveResponse = ordersService.saveNewOrder(totale, orderRequestModel.lsIdProduct());

		List<InformationOrderResponse> response = new ArrayList<InformationOrderResponse>();

		for (ProductsResponseDto productDto : lsProductOrder) {
			OrderProductResponse product = new OrderProductResponse(productDto.name(), productDto.price(),
					productDto.amount());
			InformationOrderResponse info = new InformationOrderResponse(product, totale,
					orderSaveResponse.localDateTime());
			response.add(info);
		}

		return response;
	}
}