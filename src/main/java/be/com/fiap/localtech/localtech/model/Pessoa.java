package be.com.fiap.localtech.localtech.model;

import be.com.fiap.localtech.localtech.dtos.PessoaRequestDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Pessoa {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String email;

    public Pessoa(PessoaRequestDTO pessoaDTO) {
        this.nome = pessoaDTO.nome();
        this.sobrenome = pessoaDTO.sobrenome();
        this.cpf = pessoaDTO.cpf();
        this.telefone = pessoaDTO.telefone();
        this.email = pessoaDTO.email();
    }
}
