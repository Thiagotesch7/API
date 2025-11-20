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

import com.senai.infoa.Api.Joao.Services.EquipamentosService;
import com.senai.infoa.Api.Joao.models.Equipamentos;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/Equipamentos")
public class EquipamentosController {

    @Autowired
    private EquipamentosService equipamentosService;
    
    @PostMapping("/Cadastrar")
    public ResponseEntity<String> cadastrarEquipamento (@RequestBody Equipamentos equipamentos) {
        equipamentosService.CadastrarEquipamento(equipamentos);
        return ResponseEntity.ok("Equipamento Registrado!!");
    }

    @GetMapping("/Listar")
    public List<Equipamentos> ListarEquipamentos () {
        return equipamentosService.ListarEquipamentos();
    }

    @PutMapping("/Atualizar")
    public ResponseEntity<String> atualizarEquipamento (@RequestParam Integer id, @RequestBody Equipamentos equipamentos) {
        equipamentosService.AtualizarEquipamento(id, equipamentos);
        return ResponseEntity.ok("Equipamento Atualizado com Sucesso!!");
    }

    @DeleteMapping("Deletar")
    public ResponseEntity<Void> deletarEquipamento(@RequestParam Integer id) {
        equipamentosService.DeletarEquipamentoId(id);
        return ResponseEntity.ok().build();
    }
}   

