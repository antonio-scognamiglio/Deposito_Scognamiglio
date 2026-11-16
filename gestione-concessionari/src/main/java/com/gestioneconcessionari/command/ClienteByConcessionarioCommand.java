package com.gestioneconcessionari.command;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.dto.response.ClienteResponse;
import com.gestioneconcessionari.service.ClienteService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ClienteByConcessionarioCommand {

    private final ClienteService service;
    private Long id;

    public ClienteByConcessionarioCommand(ClienteService service) {
        this.service = service;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ClienteResponse> execute() {
        return service.findClientiByConcessionarioId(id);
    }
}
