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

import com.gestioneconcessionari.command.ConcessionarioByCasaMadreCommand;
import com.gestioneconcessionari.command.ConcessionarioCreateCommand;
import com.gestioneconcessionari.command.ConcessionarioSopraMediaCommand;
import com.gestioneconcessionari.command.ConcessionarioDeleteCommand;
import com.gestioneconcessionari.command.ConcessionarioFindAllCommand;
import com.gestioneconcessionari.command.ConcessionarioGetByIdCommand;
import com.gestioneconcessionari.command.ConcessionarioUpdateCommand;
import com.gestioneconcessionari.dto.request.ConcessionarioRequest;
import com.gestioneconcessionari.dto.response.ConcessionarioResponse;

@RestController
@RequestMapping("/api/concessionari")
public class ConcessionarioController {

    private final BeanFactory beanFactory;

    public ConcessionarioController(BeanFactory beanFactory) {
        super();
        this.beanFactory = beanFactory;
    }

    @GetMapping
    public ResponseEntity<List<ConcessionarioResponse>> findAll() {
        ConcessionarioFindAllCommand command = beanFactory.getBean(ConcessionarioFindAllCommand.class);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConcessionarioResponse> findById(@PathVariable Long id) {
        ConcessionarioGetByIdCommand command = beanFactory.getBean(ConcessionarioGetByIdCommand.class);
        command.setId(id);
        return ResponseEntity.ok(command.execute());
    }

    @PostMapping
    public ResponseEntity<ConcessionarioResponse> create(@Valid @RequestBody ConcessionarioRequest request) {
        ConcessionarioCreateCommand command = beanFactory.getBean(ConcessionarioCreateCommand.class);
        command.setRequest(request);
        return ResponseEntity.status(201).body(command.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConcessionarioResponse> update(@PathVariable Long id, @Valid @RequestBody ConcessionarioRequest request) {
        ConcessionarioUpdateCommand command = beanFactory.getBean(ConcessionarioUpdateCommand.class);
        command.setId(id);
        command.setRequest(request);
        return ResponseEntity.ok(command.execute());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ConcessionarioDeleteCommand command = beanFactory.getBean(ConcessionarioDeleteCommand.class);
        command.setId(id);
        command.execute();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/casa-madre/{ragioneSociale}")
    public ResponseEntity<List<ConcessionarioResponse>> findByCasaMadre(@PathVariable String ragioneSociale) {
        ConcessionarioByCasaMadreCommand command = beanFactory.getBean(ConcessionarioByCasaMadreCommand.class);
        command.setRagioneSociale(ragioneSociale);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping("/sopra-media")
    public ResponseEntity<List<ConcessionarioResponse>> findSopraMedia() {
        ConcessionarioSopraMediaCommand command = beanFactory.getBean(ConcessionarioSopraMediaCommand.class);
        return ResponseEntity.ok(command.execute());
    }
}
