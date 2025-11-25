package com.senai.infoa.Api.Joao.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.Api.Joao.Services.MaquinaService;
import com.senai.infoa.Api.Joao.models.Maquina;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/Maquina")
public class MaquinaController {
    @Autowired
    private MaquinaService maquinaService;

    @PostMapping("/Cadastrar")
    public ResponseEntity<String> cadastrarMaquina (@RequestBody Maquina maquina) {
        maquinaService.cadastrarMaquina(maquina);
        return ResponseEntity.ok("Maquina Cadastrada");
    }

    @GetMapping("/Listar")
    public ResponseEntity<List<Maquina>> listarMaquina (@RequestParam Integer id) {
        return ResponseEntity.ok(maquinaService.listarMaquinas());
    }

    @PutMapping("/Atualizar")
    public ResponseEntity<String> atualizarMaquina (@RequestParam Integer id, @RequestBody Maquina maquina) {
        maquinaService.atualizarMaquina(id, maquina);
        return ResponseEntity.ok("Atualizado com sucesso");
    }

    @DeleteMapping("/Deletar")
    public ResponseEntity<String> deletarMaquina (@RequestParam Integer id) {
        maquinaService.deletarMaquina(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }
}
