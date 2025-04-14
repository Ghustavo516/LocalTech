package be.com.fiap.localtech.localtech.services;

import be.com.fiap.localtech.localtech.model.Pessoa;
import be.com.fiap.localtech.localtech.repositories.PessoaRepository;

import java.util.List;
import java.util.Optional;

public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAllPessoa(int page, int size) {
        int offset = (page - 1) * size;
        return pessoaRepository.findAll(offset, size);
    }

    public Optional<Pessoa> findPessoaById(Long id) {
        return pessoaRepository.findById(id);
    }

    public void updateVPessoa(Pessoa pessoa) {
        var update = pessoaRepository.save(pessoa);

        if(update == 0) {
            throw new RuntimeException("Pessoa não encontrada");
        }
    }

    public void deletePessoaById(Long id) {
        var delete = pessoaRepository.delete(id);

        if(delete == 0){
            throw new RuntimeException("Pessoa não encontrada");
        }
    }
}
