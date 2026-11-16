package order.boot.model.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponse(
        Long id,
        LocalDateTime localDateTime,
        BigDecimal total,
        String products
) {
}