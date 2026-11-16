package com.gestioneconcessionari.controller;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.gestioneconcessionari.command.ClienteByConcessionarioCommand;
import com.gestioneconcessionari.command.ClienteByNomeECognomeCommand;
import com.gestioneconcessionari.command.ClienteCreateCommand;
import com.gestioneconcessionari.command.ClienteDeleteCommand;
import com.gestioneconcessionari.command.ClienteFindAllCommand;
import com.gestioneconcessionari.command.ClienteGetByIdCommand;
import com.gestioneconcessionari.command.ClienteUpdateCommand;
import com.gestioneconcessionari.dto.request.ClienteRequest;
import com.gestioneconcessionari.dto.response.ClienteResponse;

@RestController
@RequestMapping("/api/clienti")
public class ClienteController {

    private final BeanFactory beanFactory;

    public ClienteController(BeanFactory beanFactory) {
        super();
        this.beanFactory = beanFactory;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findAll() {
        ClienteFindAllCommand command = beanFactory.getBean(ClienteFindAllCommand.class);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> findById(@PathVariable Long id) {
        ClienteGetByIdCommand command = beanFactory.getBean(ClienteGetByIdCommand.class);
        command.setId(id);
        return ResponseEntity.ok(command.execute());
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> create(@Valid @RequestBody ClienteRequest request) {
        ClienteCreateCommand command = beanFactory.getBean(ClienteCreateCommand.class);
        command.setRequest(request);
        return ResponseEntity.status(201).body(command.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> update(@PathVariable Long id, @Valid @RequestBody ClienteRequest request) {
        ClienteUpdateCommand command = beanFactory.getBean(ClienteUpdateCommand.class);
        command.setId(id);
        command.setRequest(request);
        return ResponseEntity.ok(command.execute());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ClienteDeleteCommand command = beanFactory.getBean(ClienteDeleteCommand.class);
        command.setId(id);
        command.execute();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/concessionario/{id}")
    public ResponseEntity<List<ClienteResponse>> findByConcessionario(@PathVariable Long id) {
        ClienteByConcessionarioCommand command = beanFactory.getBean(ClienteByConcessionarioCommand.class);
        command.setId(id);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping("/cerca")
    public ResponseEntity<List<ClienteResponse>> findByNomeECognome(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cognome) {
        ClienteByNomeECognomeCommand command = beanFactory.getBean(ClienteByNomeECognomeCommand.class);
        command.setNome(nome);
        command.setCognome(cognome);
        return ResponseEntity.ok(command.execute());
    }
}