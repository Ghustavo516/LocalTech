package be.com.fiap.localtech.localtech.dtos;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record VeiculoRequestsDTO(
        @NotBlank String marca,
        @NotBlank String modelo,
        @NotBlank String placa,
        @NotBlank Integer ano,
        @NotBlank String cor,
        BigDecimal valorDiaria
) {
}
