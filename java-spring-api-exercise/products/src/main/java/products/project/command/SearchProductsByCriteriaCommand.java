package products.project.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import products.project.model.request.ProductIdRequest;
import products.project.model.response.ProductsResponse;
import products.project.service.ProductsService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SearchProductsByCriteriaCommand {

	private final ProductsService productsService;
	
	private ProductIdRequest productIdRequest;

	public void setProductIdRequest(ProductIdRequest productIdRequest) {
		this.productIdRequest = productIdRequest;
	}

	public SearchProductsByCriteriaCommand(ProductsService productsService) {
		super();
		this.productsService = productsService;
	}
	
	public List<ProductsResponse> execute()
	{
		String concStr = productIdRequest.id();
		String[] arrId = concStr.split(";");	
		Map<Long, Integer> quantitaProdotti = productsOrder(arrId);
		

		return handleResponse(quantitaProdotti);
	}
	
	public Map<Long, Integer> productsOrder(String[] arrId )
	{
		Map<Long, Integer> quantitaProdotti = new HashMap<>();
		for (String id : arrId) {

		    Long productId = Long.valueOf(id);

		    quantitaProdotti.merge(productId, 1, Integer::sum);
		}
		
		return quantitaProdotti;
		
	}
	
	public List<ProductsResponse> handleResponse(Map<Long, Integer> quantitaProdotti)
	{
		List<ProductsResponse> response = new ArrayList<ProductsResponse>();
		
		for (Map.Entry<Long, Integer> entry : quantitaProdotti.entrySet()) {

		    Long productId = entry.getKey();
		    Integer quantita = entry.getValue();

		    ProductsResponse productEntity =
		            productsService.getById(productId);

		    // prezzo × quantità
		    ProductsResponse productResponse = new ProductsResponse(productId, productEntity.name(), productEntity.price(), quantita);
		    response.add(productResponse);
		    
		    productsService.updateRecord(productEntity, quantita);
		    
		}
		return response;
	}
}