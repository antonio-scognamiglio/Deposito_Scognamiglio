package com.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.service.CasaMadreService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CasaMadreDeleteCommand {

    private final CasaMadreService service;
    private Long id;

    public CasaMadreDeleteCommand(CasaMadreService service) {
        this.service = service;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void execute() {
        service.delete(id);
    }
}
