package be.com.fiap.localtech.localtech.repositories;

import be.com.fiap.localtech.localtech.dtos.PessoaRequestDTO;
import be.com.fiap.localtech.localtech.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository {

    Optional<Pessoa> findById(Long id);

    List<Pessoa> findAll(int size, int offset);

    Integer save(Pessoa pessoa);

    Integer update(Pessoa pessoa, Long id);

    Integer delete(Long id);
}
