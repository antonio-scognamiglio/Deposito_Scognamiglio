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
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.gestioneconcessionari.command.CasaMadreCreateCommand;
import com.gestioneconcessionari.command.CasaMadreDeleteCommand;
import com.gestioneconcessionari.command.CasaMadreFindAllCommand;
import com.gestioneconcessionari.command.CasaMadreGetByIdCommand;
import com.gestioneconcessionari.command.CasaMadreUpdateCommand;
import com.gestioneconcessionari.dto.request.CasaMadreRequest;
import com.gestioneconcessionari.dto.response.CasaMadreResponse;

@RestController
@RequestMapping("/api/case-madri")
public class CasaMadreController {

    private final BeanFactory beanFactory;

    public CasaMadreController(BeanFactory beanFactory) {
        super();
        this.beanFactory = beanFactory;
    }

    @GetMapping
    public ResponseEntity<List<CasaMadreResponse>> findAll() {
        CasaMadreFindAllCommand command = beanFactory.getBean(CasaMadreFindAllCommand.class);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasaMadreResponse> findById(@PathVariable Long id) {
        CasaMadreGetByIdCommand command = beanFactory.getBean(CasaMadreGetByIdCommand.class);
        command.setId(id);
        return ResponseEntity.ok(command.execute());
    }

    @PostMapping
    public ResponseEntity<CasaMadreResponse> create(@Valid @RequestBody CasaMadreRequest request) {
        CasaMadreCreateCommand command = beanFactory.getBean(CasaMadreCreateCommand.class);
        command.setRequest(request);
        return ResponseEntity.status(201).body(command.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CasaMadreResponse> update(@PathVariable Long id, @Valid @RequestBody CasaMadreRequest request) {
        CasaMadreUpdateCommand command = beanFactory.getBean(CasaMadreUpdateCommand.class);
        command.setId(id);
        command.setRequest(request);
        return ResponseEntity.ok(command.execute());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        CasaMadreDeleteCommand command = beanFactory.getBean(CasaMadreDeleteCommand.class);
        command.setId(id);
        command.execute();
        return ResponseEntity.noContent().build();
    }
}
