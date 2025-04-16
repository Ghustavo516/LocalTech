package be.com.fiap.localtech.localtech.services;

import be.com.fiap.localtech.localtech.dtos.AluguelRequestsDTO;
import be.com.fiap.localtech.localtech.exceptions.ResourceNotFoundException;
import be.com.fiap.localtech.localtech.model.Aluguel;
import be.com.fiap.localtech.localtech.repositories.AluguelRepository;
import be.com.fiap.localtech.localtech.repositories.VeiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    private final VeiculoRepository veiculoRepository;
    private final AluguelRepository aluguelRepository;

    public AluguelService(VeiculoRepository veiculoRepository, AluguelRepository aluguelRepository) {
        this.veiculoRepository = veiculoRepository;
        this.aluguelRepository = aluguelRepository;
    }

    public List<Aluguel> findAllAlugueis(int page, int size){
        int offset = (page - 1) * size;
        return aluguelRepository.findAll(size, offset);
    }

    public Optional<Aluguel> findAluguelbyId(Long id){
        return Optional.ofNullable(aluguelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluguel not found")));
    }

    public void saveAluguel(AluguelRequestsDTO aluguel){
        var aluguelEntity = calculateAluguel(aluguel);
        var save = aluguelRepository.save(aluguelEntity);
        Assert.state(save == 1,  "Erro ao salvar aluguel: " + aluguel.pessoaId());
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

    private Aluguel calculateAluguel(AluguelRequestsDTO aluguelRequestsDTO){
        var veiculo = this.veiculoRepository.findById(aluguelRequestsDTO.veiculoId())
                .orElseThrow(() -> new RuntimeException(("Veiculo não encontrado")));

        var quantDias = BigDecimal.valueOf(aluguelRequestsDTO.dataFim().getDayOfYear() - aluguelRequestsDTO.dataInicio().getDayOfYear());
        var valor = veiculo.getValorDiaria().multiply(quantDias);
        return new Aluguel(aluguelRequestsDTO, valor);
    }
}
