package com.gestioneconcessionari.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CasaMadreRequest(
        @NotBlank @Size(max = 100) String ragioneSociale,
        @NotBlank @Size(max = 100) String sedeLegale,
        @NotBlank @Size(max = 50) String paese,
        @NotNull Integer annoFondazione,
        @NotNull @DecimalMin("0") BigDecimal fatturatoAnnuo) {
}
