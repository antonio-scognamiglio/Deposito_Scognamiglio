package products.project.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import products.project.request.AddProductRequest;
import products.project.entity.ProductEntity;
import products.project.model.response.ProductsResponse;
import products.project.repository.ProductsRepository;

/**
 	* Il service prende i dati della repository, che sono presi direttamente dal db e li utilizza, c'è logica
 	* di business, ci sono mappature, validazioni, transazioni, vengono coordinate operazioni
 */
@Service
public class ProductsService {

	private final ProductsRepository productsRepository;

	public ProductsService(ProductsRepository productsRepository) {
		super();
		this.productsRepository = productsRepository;
	}
	
	public List<ProductsResponse> getAll()
	{
		List<ProductEntity> lsProducts = productsRepository.findAll();
		return lsProducts.stream().map(map -> new ProductsResponse
				(map.getId(), map.getName(), map.getPrice(), map.getAmount()))
				.toList();
	}
	
	public ProductsResponse getById(Long id)
	{
		Optional<ProductEntity> productById = productsRepository.findById(id);
		return productById.map(productEntity -> new ProductsResponse(id,
                productEntity.getName(),
                productEntity.getPrice(),
                productEntity.getAmount())).orElseGet(() -> new ProductsResponse(id, null, null, null));
	}
	
	
	public void updateRecord(ProductsResponse productEntity, Integer quantita)
	{
		Optional<ProductEntity> productById = productsRepository.findById(productEntity.id());
		Integer UpdateAmount = productById.get().getAmount() - quantita;
		productById.get().setAmount(UpdateAmount);
		productsRepository.save(productById.get());
	}

public List<ProductsResponse> getByMinAndMax(BigDecimal min, BigDecimal max){
List <ProductEntity> minAndMaxProducts = productsRepository.findByPriceRangeNative(min, max);
return minAndMaxProducts.stream().map(e-> {
    return new ProductsResponse(e.getId(), e.getName(), e.getPrice(), e.getAmount());
}).toList();
}

public ProductsResponse addNewProduct(AddProductRequest addProductRequest){
	ProductEntity productEntity = new ProductEntity();

	// These methods exist because of the @Setter annotation
	productEntity.setName(addProductRequest.name());
	productEntity.setPrice(addProductRequest.price());
	productEntity.setAmount(addProductRequest.amount());

	// Save to DB (ID is generated automatically)
	ProductEntity savedProduct = productsRepository.save(productEntity);

	return new ProductsResponse(
			savedProduct.getId(),
			savedProduct.getName(),
			savedProduct.getPrice(),
			savedProduct.getAmount()
	);

}
}