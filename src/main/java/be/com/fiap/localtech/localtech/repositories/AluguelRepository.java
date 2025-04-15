package be.com.fiap.localtech.localtech.repositories;

import be.com.fiap.localtech.localtech.model.Aluguel;

import java.util.List;
import java.util.Optional;

public interface AluguelRepository {

    Optional<Aluguel> findById(Long id);

    List<Aluguel> findAll(int size, int offset);

    Integer save(Aluguel aluguel);

    Integer update(Aluguel aluguel, Long id);

    Integer delete(Long id);
}
