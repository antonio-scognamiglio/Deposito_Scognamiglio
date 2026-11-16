package com.gestioneconcessionari.command;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.dto.response.ConcessionarioResponse;
import com.gestioneconcessionari.service.ConcessionarioService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ConcessionarioSopraMediaCommand {

    private final ConcessionarioService service;

    public ConcessionarioSopraMediaCommand(ConcessionarioService service) {
        this.service = service;
    }

    public List<ConcessionarioResponse> execute() {
        return service.findConcessionariSopraMedia();
    }
}
