package products.project.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import products.project.command.AddNewProductCommand;
import products.project.command.RecoveryAllProductsCommand;
import products.project.command.SearchBetweenPriceCommand;
import products.project.command.SearchProductsByCriteriaCommand;
import products.project.request.AddProductRequest;
import products.project.model.request.OrderRequestModel;
import products.project.model.request.ProductIdRequest;
import products.project.model.response.ProductsResponse;

/**
	* Il controller espone le rotte, gestisce le chiamate api, è il collegamento verso il mondo esterno
	* Ma le azioni effettive quelle che modificano i dati sono contenute nei command
 */
@RestController
@RequestMapping("/store")
public class ProductController {

	private final BeanFactory beanFactory;

	public ProductController(BeanFactory beanFactory) {
		super();
		this.beanFactory = beanFactory;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductsResponse>> getAllProducts()
	{
		RecoveryAllProductsCommand command = beanFactory.getBean(RecoveryAllProductsCommand.class);
		return ResponseEntity.ok(command.execute());
	}
	
	@PatchMapping("/extract")
	public ResponseEntity<List<ProductsResponse>> getProductsById(@RequestBody OrderRequestModel orderRequestModel)
	{
		ProductIdRequest productIdRequest = new ProductIdRequest(orderRequestModel.lsIdProduct());
		SearchProductsByCriteriaCommand command = beanFactory.getBean(SearchProductsByCriteriaCommand.class);
		command.setProductIdRequest(productIdRequest);
		return ResponseEntity.ok(command.execute());
	}

	@GetMapping("/range/{min}-{max}")
	public ResponseEntity<List<ProductsResponse>> getProductsInRange(
			@PathVariable BigDecimal min,
			@PathVariable BigDecimal max
	) {
		SearchBetweenPriceCommand command = beanFactory.getBean(SearchBetweenPriceCommand.class);
		/* Perché non passiamo i parametri direttamente al bean e abbiamo usato un setter dentro command?
		Si potrebbe fare, non è una best practice, ma cambia la firma di getBean, che vuole anche il service passato,
		e per passarlo dobbiamo marcare con la annotation @Autowired dentro il commando, l'istanza del service, non
		è vista come best practice perché la dependency injection ha più senso farla con i bean piuttosto che sul service
		è più soggetto a errori e quindi si preferisce usare il setter, se vogliamo usare i setter le variabili non devono
		essere final, quindi nel command si crea private BigDecimal min e private BigDecimal max.
		 */
		command.setMin(min);
		command.setMax(max);
		return ResponseEntity.ok(command.execute());
	}

	@PostMapping("/new")
	public ResponseEntity<?> addOrder(@RequestBody AddProductRequest addProductRequest){
		// --- VALIDAZIONE INLINE ---

		if (addProductRequest.name() == null || addProductRequest.name().isBlank()) {
			// Ora puoi restituire una String o una Map senza errori di compilazione
			return ResponseEntity.badRequest().body("Errore: Il nome del prodotto è obbligatorio.");
		}

		if (addProductRequest.price() == null || addProductRequest.price().compareTo(java.math.BigDecimal.ZERO) <= 0) {
			return ResponseEntity.badRequest().body("Errore: Il prezzo deve essere un numero positivo.");
		}

		if (addProductRequest.amount() == null || addProductRequest.amount() < 1) {
			return ResponseEntity.badRequest().body("Errore: La quantità deve essere almeno 1.");
		}

		// --- FINE VALIDAZIONE ---

		AddNewProductCommand command = beanFactory.getBean(AddNewProductCommand.class);
		command.setAddProductRequest(addProductRequest);

		// Restituisce il ProductsResponse (che è un oggetto, quindi è compatibile con ?)
		return ResponseEntity.ok(command.execute());
	}



}