package order.boot.model.response;

import java.math.BigDecimal;
// Oggetto innestato che si troverà nell'oggetto padre, che si chiama InformationOrderResponse
public record OrderProductResponse(String name, BigDecimal price, Integer amount) {

}
