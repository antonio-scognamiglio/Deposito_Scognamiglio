package com.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.service.ConcessionarioService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ConcessionarioDeleteCommand {

    private final ConcessionarioService service;
    private Long id;

    public ConcessionarioDeleteCommand(ConcessionarioService service) {
        this.service = service;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void execute() {
        service.delete(id);
    }
}
