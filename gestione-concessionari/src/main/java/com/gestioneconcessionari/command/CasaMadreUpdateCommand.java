package com.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.dto.request.CasaMadreRequest;
import com.gestioneconcessionari.dto.response.CasaMadreResponse;
import com.gestioneconcessionari.service.CasaMadreService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CasaMadreUpdateCommand {

    private final CasaMadreService service;
    private Long id;
    private CasaMadreRequest request;

    public CasaMadreUpdateCommand(CasaMadreService service) {
        this.service = service;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRequest(CasaMadreRequest request) {
        this.request = request;
    }

    public CasaMadreResponse execute() {
        return service.update(id, request);
    }
}
