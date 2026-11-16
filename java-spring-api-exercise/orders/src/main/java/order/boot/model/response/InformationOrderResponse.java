package order.boot.model.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record InformationOrderResponse(OrderProductResponse order, BigDecimal total, LocalDateTime time) {

}
