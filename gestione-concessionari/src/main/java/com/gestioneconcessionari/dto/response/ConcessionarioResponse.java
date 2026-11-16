package com.gestioneconcessionari.dto.response;

import java.math.BigDecimal;

public record ConcessionarioResponse(
        Long id,
        String nome,
        String citta,
        BigDecimal fatturato,
        String casaMadreNome) {
}
