package be.com.fiap.localtech.localtech.services;

import be.com.fiap.localtech.localtech.model.Pessoa;
import be.com.fiap.localtech.localtech.repositories.PessoaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
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

    public void savePessoa(Pessoa pessoa) {
        var save = pessoaRepository.save(pessoa);
        Assert.state(save == 1,  "Erro ao salvar pessoa: " + pessoa.getNome());
    }

    public void updateVPessoa(Pessoa pessoa, Long id) {
        var update = pessoaRepository.update(pessoa, id);

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
