package be.com.fiap.localtech.localtech.controllers;

import be.com.fiap.localtech.localtech.dtos.AluguelRequestsDTO;
import be.com.fiap.localtech.localtech.model.Aluguel;
import be.com.fiap.localtech.localtech.services.AluguelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/alugueis")
@Tag(name = "Veiculo", description = "Endpoint para aluguel de veiculos")
public class AluguelController {

    private static final Logger logger = LoggerFactory.getLogger(AluguelController.class);

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @Operation(
            description = "Retorna uma lista de alugueis paginada",
            summary = "Retorna uma lista de alugueis paginada",
            responses = {
                    @ApiResponse(description = "OK", responseCode = "200")
            }
    )
    @GetMapping
    public ResponseEntity<List<Aluguel>> findAllAlugueis(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        logger.info("Foi acessado o endpoint de aluguel /aluguel");
        var aluguel = aluguelService.findAllAlugueis(page, size);
        return ResponseEntity.ok(aluguel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluguel>> findIdAluguel(@PathVariable("id") Long id){
        logger.info("/aluguel/" + id);
        var aluguel = aluguelService.findAluguelbyId(id);
        return ResponseEntity.ok(aluguel);
    }

    @PostMapping
    public ResponseEntity<Void> saveAluguel(
            @Valid @RequestBody AluguelRequestsDTO aluguel
    ){
        logger.info("POST => /aluguel");
        aluguelService.saveAluguel(aluguel);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAluguel(@RequestBody Aluguel aluguel, @PathVariable Long id){
        logger.info("PUT => /aluguel");
        aluguelService.updateAluguel(aluguel, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluguel(@PathVariable Long id){
        logger.info("DELETE => /veiculos");
        aluguelService.deleteAluguel(id);
        return ResponseEntity.ok().build();
    }
}
