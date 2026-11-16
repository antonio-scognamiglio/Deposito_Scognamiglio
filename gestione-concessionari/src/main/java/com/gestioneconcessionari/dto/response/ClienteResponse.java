package com.gestioneconcessionari.dto.response;

public record ClienteResponse(
                Long id,
                String nome,
                String cognome,
                String email,
                String concessionarioNome,
                String concessionarioCitta,
                String casaMadreNome) {
}
