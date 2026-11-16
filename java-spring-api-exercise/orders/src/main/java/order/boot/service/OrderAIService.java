package order.boot.service;

import order.boot.dto.PersonDto;
import order.boot.tools.OrderToolAI;

import java.util.UUID;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

/**
 * Servizio AI per la gestione degli ordini.
 *
 * <p>Mechanism of memory: {@code MessageChatMemoryAdvisor} is activated on the client,
 * so every request automatically re-injects the conversation history saved in
 * {@code ChatMemory} before sending the prompt to the model.
 * The {@code conversationId} identifies a single conversation shared by all requests
 * (singleton scope): all clients share the same chat history.</p>
 *
 * <p>RAG: {@code QuestionAnswerAdvisor} retrieves relevant chunks from the
 * {@code VectorStore} and injects them as context before calling the model.</p>
 */
@Service
public class OrderAIService {

    private final ChatClient chatClient;
    private final OrderToolAI orderToolAi;
    private final VectorStore vectorStore;

    // Single conversation ID: created once at startup, shared by every request.
    private String conversationId = UUID.randomUUID().toString();

    public OrderAIService(ChatClient.Builder chatClientBuilder,
                          OrderToolAI tool,
                          ChatMemory chatMemory,
                          VectorStore vectorStore) {
        super();
        this.orderToolAi = tool;
        this.vectorStore = vectorStore;
        // Builds the client with:
        //  - tools: OrderToolAI (get orders, create order...)
        //  - advisors: MessageChatMemoryAdvisor -> injects past messages into every prompt
        //  - advisor param: binds conversationId so all requests share the same history
        //  - advisor: QuestionAnswerAdvisor -> RAG retrieval from the VectorStore
        this.chatClient = chatClientBuilder.defaultTools(tool)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultAdvisors(advisor -> advisor.param(
                        ChatMemory.CONVERSATION_ID,
                        conversationId))
                .defaultAdvisors(QuestionAnswerAdvisor.builder(vectorStore).build())
                .build();
    }

    // Memory is active here: the advisor automatically adds previous messages
    // to the prompt before calling the model. You pass only the new question.
    public String testMemoryAI(String question) {
        return chatClient.prompt()
                .user(question)
                .call()
                .content();
    }

    public String getResponseByAI(String question) {
        return chatClient.prompt()
                .user(question)
                .call()
                .content();
    }

    /**
     * RAG: risponde usando esclusivamente i documenti recuperati dal VectorStore.
     */
    public String askPolicy(String question) {
        return chatClient.prompt()
                .system("""
                    Sei un assistente aziendale.
                    Rispondi alle domande relative alle
                    procedure ferie utilizzando esclusivamente
                    le informazioni presenti nei documenti
                    recuperati.

                    Se l'informazione non è presente,
                    dichiara che non è disponibile
                    nella documentazione aziendale.
                    """)
                .user(question)
                .call()
                .content();
    }

    /**
     * Estrae nome, cognome ed età da una descrizione testuale di una persona.
     * L'LLM trasforma il text libero in un oggetto {@link PersonDto} tramite output
     * strutturato.
     */
    public PersonDto extractPersonData(String text) {
        return chatClient.prompt()
                .user(u -> u.text("""
                        Estrai nome, cognome, età e professione dal text.
                        Se un dato non è presente, usa null.
                        Non inventare informazioni.
                        Testo: {text}
                        """)
                        .param("text", text))
                .call()
                .entity(PersonDto.class);
    }
}
