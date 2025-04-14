package be.com.fiap.localtech.localtech.controllers;

import be.com.fiap.localtech.localtech.model.Veiculo;
import be.com.fiap.localtech.localtech.services.VeiculosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    //Armazena os logs do controlador
    private static final Logger logger = LoggerFactory.getLogger(VeiculoController.class);

    private final VeiculosService veiculoService;

    public VeiculoController(VeiculosService veiculoService) {
        this.veiculoService = veiculoService;
    }

    //http://localhost:8080/veiculos?page=1&size=10       -> Isso é uma queryParams (passamos diversos dados como parametros direto na URI)
    @GetMapping
    public ResponseEntity<List<Veiculo>> findAllVeiculo(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        logger.info("Foi acessado o endpoint de veiculos /veiculos");
        var veiculos = veiculoService.findAllVeiculos(page, size);
        return ResponseEntity.ok(veiculos);
    }

    //http://localhost:8080/veiculos/1       -> Isso é uma requestParams (passamos apenas um valor)
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> findAllVeiculos(@PathVariable("id") Long id){
        logger.info("/veiculos/" + id);
        var veiculo = veiculoService.findVeiculobyId(id);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    public ResponseEntity<Void> saveVeiculo(
            @RequestBody Veiculo veiculo
    ){
        logger.info("POST => /veiculos");
        veiculoService.saveVeiculo(veiculo);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVeiculo(@RequestBody Veiculo veiculo, @PathVariable Long id){
        logger.info("PUT => /veiculos");
        veiculoService.updateVeiculo(veiculo, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable Long id){
        logger.info("DELETE => /veiculos");
        veiculoService.deleteVeiculo(id);
        return ResponseEntity.ok().build();
    }
}
