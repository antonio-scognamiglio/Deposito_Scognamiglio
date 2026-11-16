package order.boot.command;

import order.boot.dto.PersonDto;
import order.boot.service.OrderAIService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ExtractInformationByTextCommand {

    private final OrderAIService aiService;

    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public ExtractInformationByTextCommand(OrderAIService aiService) {
        super();
        this.aiService = aiService;
    }

    public PersonDto execute() {
        return aiService.extractPersonData(text);
    }
}
