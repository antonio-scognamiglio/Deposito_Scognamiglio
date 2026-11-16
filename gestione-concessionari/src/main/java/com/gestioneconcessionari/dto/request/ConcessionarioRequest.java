package com.gestioneconcessionari.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ConcessionarioRequest(
        @NotBlank @Size(max = 100) String nome,
        @NotBlank @Size(max = 100) String citta,
        @NotBlank @Size(max = 150) String indirizzo,
        @NotBlank @Size(max = 20) String telefono,
        @NotNull @DecimalMin("0") BigDecimal fatturato,
        @NotNull Long casaMadreId) {
}
