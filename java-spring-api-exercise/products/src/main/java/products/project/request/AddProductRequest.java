package products.project.request;

import java.math.BigDecimal;

public record AddProductRequest(
        String name,
        BigDecimal price,
        Integer amount) {
}
