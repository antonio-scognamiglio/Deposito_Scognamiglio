package com.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.dto.response.ClienteResponse;
import com.gestioneconcessionari.service.ClienteService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ClienteGetByIdCommand {

    private final ClienteService service;
    private Long id;

    public ClienteGetByIdCommand(ClienteService service) {
        this.service = service;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteResponse execute() {
        return service.findById(id);
    }
}
