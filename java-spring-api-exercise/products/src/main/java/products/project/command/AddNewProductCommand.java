package products.project.command;

import lombok.Setter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import products.project.request.AddProductRequest;
import products.project.model.response.ProductsResponse;
import products.project.service.ProductsService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AddNewProductCommand {

    private final ProductsService productsService;
    @Setter
    private AddProductRequest addProductRequest;

    public AddNewProductCommand(ProductsService productsService) {
        super();
        this.productsService = productsService;
    }

    public ProductsResponse execute(){
        return productsService.addNewProduct(addProductRequest);
    }
}
