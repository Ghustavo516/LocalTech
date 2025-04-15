package be.com.fiap.localtech.localtech.services;

import be.com.fiap.localtech.localtech.model.Aluguel;
import be.com.fiap.localtech.localtech.repositories.AluguelRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {
    
    private final AluguelRepository aluguelRepository;

    public AluguelService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public List<Aluguel> findAllAluguel(int page, int size){
        int offset = (page - 1) * size;
        return aluguelRepository.findAll(size, offset);
    }

    public Optional<Aluguel> findAluguelbyId(Long id){
        return aluguelRepository.findById(id);
    }

    public void saveAluguel(Aluguel aluguel){
        var save = aluguelRepository.save(aluguel);
        Assert.state(save == 1,  "Erro ao salvar aluguel: " + aluguel.getVeiculo().getModelo());
    }

    public void updateAluguel(Aluguel aluguel, Long id){
        var update = aluguelRepository.update(aluguel, id);

        if(update == 0){
            throw  new RuntimeException("Aluguel não encontrado");
        }
    }

    public void deleteAluguel(Long id){
        var delete = aluguelRepository.delete(id);

        if(delete == 0){
            throw  new RuntimeException("Aluguel não encontrado");
        }
    }
}
