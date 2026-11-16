package com.gestioneconcessionari.mapper;

import org.springframework.stereotype.Component;

import com.gestioneconcessionari.dto.response.CasaMadreResponse;
import com.gestioneconcessionari.dto.response.ClienteResponse;
import com.gestioneconcessionari.dto.response.ConcessionarioResponse;
import com.gestioneconcessionari.entity.CasaMadre;
import com.gestioneconcessionari.entity.Cliente;
import com.gestioneconcessionari.entity.Concessionario;

@Component
public class EntityMapper {

    public ClienteResponse toClienteResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCognome(),
                cliente.getEmail(),
                cliente.getConcessionario().getNome(),
                cliente.getConcessionario().getCitta(),
                cliente.getConcessionario().getCasaMadre().getRagioneSociale()
        );
    }

    public ConcessionarioResponse toConcessionarioResponse(Concessionario concessionario) {
        return new ConcessionarioResponse(
                concessionario.getId(),
                concessionario.getNome(),
                concessionario.getCitta(),
                concessionario.getFatturato(),
                concessionario.getCasaMadre().getRagioneSociale()
        );
    }

    public CasaMadreResponse toCasaMadreResponse(CasaMadre casaMadre) {
        return new CasaMadreResponse(
                casaMadre.getId(),
                casaMadre.getRagioneSociale(),
                casaMadre.getSedeLegale(),
                casaMadre.getPaese(),
                casaMadre.getAnnoFondazione(),
                casaMadre.getFatturatoAnnuo()
        );
    }
}
