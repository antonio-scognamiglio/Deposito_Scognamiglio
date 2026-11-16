package com.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.dto.response.ConcessionarioResponse;
import com.gestioneconcessionari.service.ConcessionarioService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ConcessionarioGetByIdCommand {

    private final ConcessionarioService service;
    private Long id;

    public ConcessionarioGetByIdCommand(ConcessionarioService service) {
        this.service = service;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConcessionarioResponse execute() {
        return service.findById(id);
    }
}
