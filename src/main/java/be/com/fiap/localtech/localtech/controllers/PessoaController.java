package be.com.fiap.localtech.localtech.controllers;

import be.com.fiap.localtech.localtech.model.Pessoa;
import be.com.fiap.localtech.localtech.services.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPessoas(@RequestParam("page") int page, @RequestParam("size") int size) {
        return ResponseEntity.ok(pessoaService.findAllPessoa(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> getPessoaById(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.findPessoaById(id));
    }

    @PostMapping
    public ResponseEntity<Void> savePessoa(@RequestBody Pessoa pessoa){
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePessoa(@RequestBody Pessoa pessoa, @PathVariable Long id){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delelePessoa(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }
}
