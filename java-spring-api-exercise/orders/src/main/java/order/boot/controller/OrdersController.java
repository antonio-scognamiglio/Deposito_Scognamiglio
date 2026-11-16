package order.boot.controller;

import java.util.List;

import order.boot.command.*;
import order.boot.dto.PersonDto;
import order.boot.model.request.ChatRequest;
import order.boot.model.request.ChatRequestModel;
import order.boot.model.request.PersonTextRequest;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import order.boot.dto.ProductsResponseDto;
import order.boot.model.request.OrderRequest;
import order.boot.model.request.OrderRequestModel;
import order.boot.model.response.InformationOrderResponse;
import order.boot.model.response.OrderResponse;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final BeanFactory beanFactory;

    public OrdersController(BeanFactory beanFactory) {
        super();
        this.beanFactory = beanFactory;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderResponse>> recoveryAllOrders() {
        RecoveryAllOrdersCommand command = beanFactory.getBean(RecoveryAllOrdersCommand.class);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        GetOrderCommand command = beanFactory.getBean(GetOrderCommand.class);
        command.setId(id);
        return ResponseEntity.ok(command.execute());
    }

    @PostMapping("/new")
    public ResponseEntity<List<InformationOrderResponse>> addOrder(@RequestBody OrderRequest orderRequest) {
        OrderRequestModel model = new OrderRequestModel(orderRequest.lsIdProduct());
        AddOrderCommand command = beanFactory.getBean(AddOrderCommand.class);
        command.setOrderRequestModel(model);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping("/product/available")
    public ResponseEntity<List<ProductsResponseDto>> getAllProducts() {
        GetAllProductsCommand command = beanFactory.getBean(GetAllProductsCommand.class);
        return ResponseEntity.ok(command.execute());
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable Long id) {
        DeleteOrderCommand command = beanFactory.getBean(DeleteOrderCommand.class);
        command.setId(id);
        try {
            command.execute();
            return ResponseEntity.ok("success");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @PostMapping("/ai/chat")
    public ResponseEntity<String> executeQuestionAI(@RequestBody ChatRequest chatRequest) {
        ChatRequestModel request = new ChatRequestModel(chatRequest.request());
        OrderAICommand command = beanFactory.getBean(OrderAICommand.class);
        command.setChatRequestModel(request);
        return ResponseEntity.ok(command.execute());
    }

    @PostMapping("/ai/person/extract")
    public ResponseEntity<PersonDto> extractPerson(@RequestBody PersonTextRequest personTextRequest) {
        ExtractInformationByTextCommand command = beanFactory.getBean(ExtractInformationByTextCommand.class);
        command.setText(personTextRequest.text());
        return ResponseEntity.ok(command.execute());
    }

    // /ai/memory: each request gets a fresh prototype command instance,
    // but the AI service (singleton) keeps one conversationId across all requests,
    // so the model "remembers" previous turns automatically via ChatMemory.
    @PostMapping("ai/memory")
    public ResponseEntity<String> extractByChatMemory(@RequestBody ChatRequest chatRequest) {
        ChatRequestModel request = new ChatRequestModel(chatRequest.request());
        OrderChatMemoryAICommand command = beanFactory.getBean(OrderChatMemoryAICommand.class);
        command.setChatRequestModel(request);
        return ResponseEntity.ok(command.execute());
    }

    // RAG: risponde usando i documenti recuperati dal VectorStore.
    @PostMapping("chat/rag")
    public ResponseEntity<String> getInfoPolicySociety(@RequestBody ChatRequest chatRequest) {
        ChatRequestModel request = new ChatRequestModel(chatRequest.request());
        OrderRagAICommand command = beanFactory.getBean(OrderRagAICommand.class);
        command.setChatRequestModel(request);
        return ResponseEntity.ok(command.execute());
    }
}
