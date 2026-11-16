package com.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.dto.request.ConcessionarioRequest;
import com.gestioneconcessionari.dto.response.ConcessionarioResponse;
import com.gestioneconcessionari.service.ConcessionarioService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ConcessionarioCreateCommand {

    private final ConcessionarioService service;
    private ConcessionarioRequest request;

    public ConcessionarioCreateCommand(ConcessionarioService service) {
        this.service = service;
    }

    public void setRequest(ConcessionarioRequest request) {
        this.request = request;
    }

    public ConcessionarioResponse execute() {
        return service.create(request);
    }
}
