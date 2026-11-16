package com.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.dto.request.ClienteRequest;
import com.gestioneconcessionari.dto.response.ClienteResponse;
import com.gestioneconcessionari.service.ClienteService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ClienteUpdateCommand {

    private final ClienteService service;
    private Long id;
    private ClienteRequest request;

    public ClienteUpdateCommand(ClienteService service) {
        this.service = service;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRequest(ClienteRequest request) {
        this.request = request;
    }

    public ClienteResponse execute() {
        return service.update(id, request);
    }
}
