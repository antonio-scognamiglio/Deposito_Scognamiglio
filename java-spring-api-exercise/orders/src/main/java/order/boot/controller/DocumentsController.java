package order.boot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import order.boot.service.DocumentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/documents")
public class DocumentsController {

    private final DocumentsService documentsService;

    public DocumentsController(DocumentsService documentsService) {
        super();
        this.documentsService = documentsService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        Path path = Files.createTempFile("procedure", ".txt");
        file.transferTo(path);
        documentsService.uploadDocument(path.toString());
        return ResponseEntity.ok("Documento caricato correttamente");
    }
}
