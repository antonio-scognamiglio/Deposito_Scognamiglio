package products.project.model.response;

import java.math.BigDecimal;

public record ProductsResponse(Long id, String name, BigDecimal price, Integer amount) {

}
