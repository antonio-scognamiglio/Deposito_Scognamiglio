package order.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import order.boot.dto.ProductsResponseDto;
import order.boot.model.request.OrderRequestModel;

@Service
public class OrderProductsService {

    private final RestClient restClient;
    private final String productServiceUrl;

    public OrderProductsService(
            RestClient.Builder builder,
            @Value("${product-service.url}") String productServiceUrl) {

        this.restClient = builder.build();
        this.productServiceUrl = productServiceUrl;
    }

    public List<ProductsResponseDto> findAllProduct() {

        return restClient
                .get()
                .uri(productServiceUrl + "/all")
                .retrieve()
                .body(new ParameterizedTypeReference<List<ProductsResponseDto>>() {});
    }

    public List<ProductsResponseDto> findProductsById(OrderRequestModel orderRequestModel) {

        return restClient
                .patch()
                .uri(productServiceUrl + "/extract")
                .body(orderRequestModel)
                .retrieve()
                .body(new ParameterizedTypeReference<List<ProductsResponseDto>>() {});
    }
}