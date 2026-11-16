package order.boot.service;

import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.ai.vectorstore.VectorStore;

@Service
public class DocumentsService {

    private final VectorStore vectorStore;

    public DocumentsService(VectorStore vectorStore) {
        super();
        this.vectorStore = vectorStore;
    }

    public void uploadDocument(String path) {
        // Lettura documento TXT
        TextReader reader = new TextReader(new FileSystemResource(path));
        List<Document> documents = reader.get();

        // Chunking
        TokenTextSplitter splitter = TokenTextSplitter.builder()
                .withChunkSize(500)
                .build();

        List<Document> chunks = splitter.apply(documents);

        // Salvataggio nel Vector Store
        vectorStore.add(chunks);
    }
}
