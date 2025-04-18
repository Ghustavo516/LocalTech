package be.com.fiap.localtech.localtech.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PessoaRequestDTO(
        @NotNull @NotBlank String nome,
        @NotNull @NotBlank String sobrenome,
        @NotNull @NotBlank String cpf,
        String telefone,
        String email) {
}
