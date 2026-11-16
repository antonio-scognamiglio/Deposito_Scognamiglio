package products.project.command;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import products.project.model.response.ProductsResponse;
import products.project.service.ProductsService;

/**
 * Rappresenta l'azione specifica del sistema.
 * Riceve la chiamata dal controller ed esegue il compito operativo delegandolo al service.
 * Credo che il pattern più elegante sia chiamare i payload con un suffisso DTO e le risposte
 * alle GET con un suffisso Response
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RecoveryAllProductsCommand {

	private final ProductsService productsService;

	public RecoveryAllProductsCommand(ProductsService productsService) {
		super();
		this.productsService = productsService;
	}
	
	public List<ProductsResponse> execute()
	{
		return productsService.getAll();
	}
}