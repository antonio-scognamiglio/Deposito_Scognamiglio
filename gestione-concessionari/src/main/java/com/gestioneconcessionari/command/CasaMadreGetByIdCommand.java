package com.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.dto.response.CasaMadreResponse;
import com.gestioneconcessionari.service.CasaMadreService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CasaMadreGetByIdCommand {

    private final CasaMadreService service;
    private Long id;

    public CasaMadreGetByIdCommand(CasaMadreService service) {
        this.service = service;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CasaMadreResponse execute() {
        return service.findById(id);
    }
}
