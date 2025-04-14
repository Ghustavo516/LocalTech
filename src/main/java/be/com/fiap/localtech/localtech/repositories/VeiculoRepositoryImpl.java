package be.com.fiap.localtech.localtech.repositories;

import be.com.fiap.localtech.localtech.model.Veiculo;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VeiculoRepositoryImpl implements VeiculoRepository {

    //Injeção de dependencias
    private final JdbcClient jdbcClient;

    public VeiculoRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    //========================================

    @Override
    public Optional<Veiculo> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT * FROM veiculos WHERE id = :id")
                .param("id", id)
                .query(Veiculo.class) //Converte os dados da query para dentro do nosso objeto
                .optional();
    }

    @Override
    public List<Veiculo> findAll(int size, int offset) {
        //Atraves do comando sql LIMIT definimos a quantidade que deve ser buscada e OFFSET o intervalo
        return this.jdbcClient
                .sql("SELECT * FROM veiculos LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Veiculo.class)
                .list();
    }

    @Override
    public Integer save(Veiculo veiculo) {
        return this.jdbcClient
                .sql("INSERT INTO veiculos (marca, modelo, placa, ano, cor, valor_diaria) VALUES (:marca, :modelo, :placa, :ano, :cor, :valor_diaria)")
                .param("marca", veiculo.getMarca())
                .param("modelo", veiculo.getModelo())
                .param("placa", veiculo.getPlaca())
                .param("ano", veiculo.getAno())
                .param("cor", veiculo.getCor())
                .param("valor_diaria", veiculo.getValorDiaria())
                .update();
    }

    @Override
    public Integer update(Veiculo veiculo, Long id) {
        return this.jdbcClient
                .sql("UPDATE veiculos SET marca = :marca, modelo = :modelo, placa = :placa, ano = :ano, cor = :cor, valor_diaria = :valor_diaria")
                .param("marca", veiculo.getMarca())
                .param("modelo", veiculo.getModelo())
                .param("placa", veiculo.getPlaca())
                .param("ano", veiculo.getAno())
                .param("cor", veiculo.getCor())
                .param("valor_diaria", veiculo.getValorDiaria())
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM veiculos WHERE id = :id")
                .param("id", id)
                .update();
    }
}
