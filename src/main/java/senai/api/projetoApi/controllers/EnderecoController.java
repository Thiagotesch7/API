package senai.api.projetoApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.api.projetoApi.models.Endereco;
import senai.api.projetoApi.repositories.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> buscarPorCep(@PathVariable String cep) {
        Endereco endereco = enderecoRepository.findByCep(cep);
        if (endereco == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(endereco);
    }

    @PostMapping
    public Endereco salvarEndereco(@RequestBody Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}
