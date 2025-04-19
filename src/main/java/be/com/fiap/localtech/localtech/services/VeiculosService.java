package be.com.fiap.localtech.localtech.services;

import be.com.fiap.localtech.localtech.dtos.VeiculoRequestsDTO;
import be.com.fiap.localtech.localtech.model.Veiculo;
import be.com.fiap.localtech.localtech.repositories.VeiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculosService {

    private final VeiculoRepository veiculoRepository;

    public VeiculosService(VeiculoRepository veiculoRepository){
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> findAllVeiculos(int page, int size){
        int offset = (page - 1) * size;
        return veiculoRepository.findAll(size, offset);
    }

    public Optional<Veiculo> findVeiculobyId(Long id){
        return veiculoRepository.findById(id);
    }

    public void saveVeiculo(VeiculoRequestsDTO veiculo){
        var save = veiculoRepository.save(new Veiculo(veiculo));
        Assert.state(save == 1,  "Erro ao salvar veiculo " + veiculo.modelo());
    }

    public void updateVeiculo(Veiculo veiculo, Long id){
        var update = veiculoRepository.update(veiculo, id);

        if(update == 0){
            throw  new RuntimeException("Veiculo não encontrado");
        }
    }

    public void deleteVeiculo(Long id){
        var delete = veiculoRepository.delete(id);

        if(delete == 0){
            throw  new RuntimeException("Veiculo não encontrado");
        }
    }






}
