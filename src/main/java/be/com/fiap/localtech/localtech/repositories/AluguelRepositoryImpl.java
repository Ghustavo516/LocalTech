package be.com.fiap.localtech.localtech.repositories;

import be.com.fiap.localtech.localtech.model.Aluguel;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AluguelRepositoryImpl implements AluguelRepository{

    private final JdbcClient jdbcClient;

    public AluguelRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Aluguel> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT * FROM aluguel WHERE id: :id")
                .param("id", id)
                .query(Aluguel.class)
                .optional();
    }

    @Override
    public List<Aluguel> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM aluguel LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Aluguel.class)
                .list();
    }

    @Override
    public Integer save(Aluguel aluguel) {
        return this.jdbcClient
                .sql("INSERT INTO veiculos (pessoa, veiculo, veiculoModelo, dataInicio, dataFim, valorTotal) VALUES (:pessoa, :veiculo, :veiculoModelo, :dataInicio, :dataFim, :valorTotal)")
                .param("pessoa", aluguel.getPessoa())
                .param("veiculo", aluguel.getVeiculo())
                .param("veiculoModelo", aluguel.getVeiculoModelo())
                .param("dataInicio", aluguel.getDataInicio())
                .param("dataFim", aluguel.getDataFim())
                .param("valorTotal", aluguel.getValorTotal())
                .update();
    }

    @Override
    public Integer update(Aluguel aluguel, Long id) {
        return this.jdbcClient
                .sql("UPDATE aluguel SET pessoa =:pessoa, veiculo=:veiculo, veiculoModelo=:veiculoModelo, dataInicio=:dataInicio, dataFim=:dataFim, valorTotal=:valorTotal WHERE ID = :id")
                .param("pessoa", aluguel.getPessoa())
                .param("veiculo", aluguel.getVeiculo())
                .param("veiculoModelo", aluguel.getVeiculoModelo())
                .param("dataInicio", aluguel.getDataInicio())
                .param("dataFim", aluguel.getDataFim())
                .param("valorTotal", aluguel.getValorTotal())
                .param("id", aluguel.getId())
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM pessoa WHERE ID = :id")
                .param("id", id)
                .update();
    }
}
