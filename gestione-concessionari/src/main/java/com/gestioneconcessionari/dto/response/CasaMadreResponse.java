package com.gestioneconcessionari.dto.response;

import java.math.BigDecimal;

public record CasaMadreResponse(
        Long id,
        String ragioneSociale,
        String sedeLegale,
        String paese,
        Integer annoFondazione,
        BigDecimal fatturatoAnnuo) {
}
