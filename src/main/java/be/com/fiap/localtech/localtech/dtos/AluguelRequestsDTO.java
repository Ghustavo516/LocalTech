package be.com.fiap.localtech.localtech.dtos;

import java.time.LocalDate;

public record AluguelRequestsDTO(Long pessoaId, Long veiculoId, LocalDate dataInicio, LocalDate dataFim) {

}
