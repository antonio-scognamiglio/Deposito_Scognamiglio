package order.boot.command;

import order.boot.model.request.ChatRequestModel;
import order.boot.service.OrderAIService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class OrderAICommand {

    private final OrderAIService aiService;

    private ChatRequestModel chatRequestModel;

    public void setChatRequestModel(ChatRequestModel chatRequestModel) {
        this.chatRequestModel = chatRequestModel;
    }

    public OrderAICommand(OrderAIService aiService) {
        super();
        this.aiService = aiService;
    }

    public String execute() {
        return aiService.getResponseByAI(chatRequestModel.question());
    }
}