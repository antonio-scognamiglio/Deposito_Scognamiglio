package order.boot.command;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.BeanDefinition;

import order.boot.model.request.ChatRequestModel;
import order.boot.service.OrderAIService;

/**
 * Command for the /ai/memory endpoint.
 *
 * <p>
 * Prototype scope: a new instance is created per HTTP request, so each request
 * gets its own {@code chatRequestModel}. The underlying {@code OrderAIService}
 * is a
 * singleton, so all requests share the same {@code conversationId} and
 * therefore
 * the same conversation history.
 * </p>
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class OrderChatMemoryAICommand {

    private final OrderAIService aiService;

    // Set by the controller before execute() is called.
    private ChatRequestModel chatRequestModel;

    public void setChatRequestModel(ChatRequestModel chatRequestModel) {
        this.chatRequestModel = chatRequestModel;
    }

    public OrderChatMemoryAICommand(OrderAIService aiService) {
        super();
        this.aiService = aiService;
    }

    // Delegates to the AI service. Memory is handled automatically by the advisor
    // inside OrderAIService — no manual context passing needed here.
    public String execute() {
        return aiService.testMemoryAI(chatRequestModel.question());
    }

}
