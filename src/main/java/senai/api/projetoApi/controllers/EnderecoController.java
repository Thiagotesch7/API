package senai.api.projetoApi.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import senai.api.projetoApi.models.Endereco;
import senai.api.projetoApi.repositories.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    
   @GetMapping("/enderecos/{cep}")
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
