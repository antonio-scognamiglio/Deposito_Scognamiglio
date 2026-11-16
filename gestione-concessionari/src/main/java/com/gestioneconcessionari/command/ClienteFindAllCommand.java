package com.gestioneconcessionari.command;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.dto.response.ClienteResponse;
import com.gestioneconcessionari.service.ClienteService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ClienteFindAllCommand {

    private final ClienteService service;

    public ClienteFindAllCommand(ClienteService service) {
        this.service = service;
    }

    public List<ClienteResponse> execute() {
        return service.findAll();
    }
}
