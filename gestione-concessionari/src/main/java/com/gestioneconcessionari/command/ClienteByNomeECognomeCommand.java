package com.gestioneconcessionari.command;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gestioneconcessionari.dto.response.ClienteResponse;
import com.gestioneconcessionari.service.ClienteService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ClienteByNomeECognomeCommand {

    private final ClienteService service;
    private String nome;
    private String cognome;

    public ClienteByNomeECognomeCommand(ClienteService service) {
        this.service = service;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public List<ClienteResponse> execute() {
        return service.findClientiByNomeECognome(nome, cognome);
    }
}
