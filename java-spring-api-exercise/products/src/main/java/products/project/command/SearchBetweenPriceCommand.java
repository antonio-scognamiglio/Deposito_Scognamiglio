package products.project.command;

import lombok.Setter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import products.project.model.response.ProductsResponse;
import products.project.service.ProductsService;

import java.math.BigDecimal;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SearchBetweenPriceCommand {
    private final ProductsService productsService;
    @Setter
    private BigDecimal min;
    @Setter
    private BigDecimal max;


    public SearchBetweenPriceCommand(ProductsService productsService) {
        super();
        this.productsService = productsService;
    }

    public List<ProductsResponse> execute()
    {
        return productsService.getByMinAndMax(min, max);
    }

}
