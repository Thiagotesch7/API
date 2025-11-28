package com.senai.infoa.Api.para.ApiCall.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.Api.para.ApiCall.Models.Endereco;
import com.senai.infoa.Api.para.ApiCall.Services.EnderecoService;

@RestController
@RequestMapping("/Endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    public ResponseEntity<String> cadastrarEndereco (@RequestBody Endereco endereco) {
        enderecoService.cadastrarEndereco(endereco);
        return ResponseEntity.ok("Cadastrado com sucesso");
    }
}
