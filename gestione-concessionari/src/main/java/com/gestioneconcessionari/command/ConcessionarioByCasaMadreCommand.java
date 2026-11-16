package com.gestioneconcessionari.command;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.dto.response.ConcessionarioResponse;
import com.gestioneconcessionari.service.ConcessionarioService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ConcessionarioByCasaMadreCommand {

    private final ConcessionarioService service;
    private String ragioneSociale;

    public ConcessionarioByCasaMadreCommand(ConcessionarioService service) {
        this.service = service;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public List<ConcessionarioResponse> execute() {
        return service.findConcessionariByCasaMadreRagioneSociale(ragioneSociale);
    }
}
