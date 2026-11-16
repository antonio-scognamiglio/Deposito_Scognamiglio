package com.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.dto.request.ClienteRequest;
import com.gestioneconcessionari.dto.response.ClienteResponse;
import com.gestioneconcessionari.service.ClienteService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ClienteCreateCommand {

    private final ClienteService service;
    private ClienteRequest request;

    public ClienteCreateCommand(ClienteService service) {
        this.service = service;
    }

    public void setRequest(ClienteRequest request) {
        this.request = request;
    }

    public ClienteResponse execute() {
        return service.create(request);
    }
}
