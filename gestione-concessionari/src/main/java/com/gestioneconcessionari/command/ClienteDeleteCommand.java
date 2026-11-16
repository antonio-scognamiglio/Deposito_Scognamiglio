package com.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.service.ClienteService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ClienteDeleteCommand {

    private final ClienteService service;
    private Long id;

    public ClienteDeleteCommand(ClienteService service) {
        this.service = service;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void execute() {
        service.delete(id);
    }
}
