package be.com.fiap.localtech.localtech.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AluguelRequestsDTO(

        @Schema(description = "O id da pessoa que esta alugando o veiculo", example = "1")
        @NotNull(message = "O id da pessoa não pode ser nulo")
        Long pessoaId,

        @NotNull(message = "O id da veiculo não pode ser nulo")
        Long veiculoId,
        LocalDate dataInicio,
        LocalDate dataFim) {
}
