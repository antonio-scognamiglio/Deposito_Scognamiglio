package order.boot.configuration;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AIConfiguration {

    @Bean
    @Primary
    public ChatModel primaryChatModel(OpenAiChatModel openAiChatModel) {
        return openAiChatModel;
    }
}
