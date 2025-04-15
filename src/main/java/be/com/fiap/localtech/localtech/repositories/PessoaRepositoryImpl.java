package be.com.fiap.localtech.localtech.repositories;

import be.com.fiap.localtech.localtech.model.Pessoa;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository {

    private final JdbcClient jdbcClient;

    public PessoaRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        return this.jdbcClient.sql("SELECT * FROM pessoa WHERE id = :id")
                .param("id", id)
                .query(Pessoa.class)
                .optional();
    }

    @Override
    public List<Pessoa> findAll(int size, int offset) {
        return this.jdbcClient.
                sql("SELECT * FROM pessoa LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Pessoa.class)
                .list();
    }

    @Override
    public Integer save(Pessoa pessoa) {
        return this.jdbcClient
                .sql("INSERT INTO pessoa (nome, sobrenome, cpf, telefone, email) VALUES (:nome, :sobrenome, :cpf, :telefone, :email)")
                .param("nome", pessoa.getNome())
                .param("sobrenome", pessoa.getSobrenome())
                .param("cpf", pessoa.getCpf())
                .param("telefone", pessoa.getTelefone())
                .param("email", pessoa.getEmail())
                .update();
    }

    @Override
    public Integer update(Pessoa pessoa, Long id) {
        return this.jdbcClient
                .sql("UPDATE pessoa SET nome = :nome, sobrenome = :sobrenome, cpf = :cpf, telefone =:telefone, email = :email")
                .param("nome", pessoa.getNome())
                .param("sobrenome", pessoa.getSobrenome())
                .param("cpf", pessoa.getCpf())
                .param("telefone", pessoa.getTelefone())
                .param("email", pessoa.getEmail())
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM pessoa WHERE id = :id")
                .param("id", id)
                .update();
    }
}
