package com.gestioneconcessionari.command;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.dto.response.CasaMadreResponse;
import com.gestioneconcessionari.service.CasaMadreService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CasaMadreFindAllCommand {

    private final CasaMadreService service;

    public CasaMadreFindAllCommand(CasaMadreService service) {
        this.service = service;
    }

    public List<CasaMadreResponse> execute() {
        return service.findAll();
    }
}
