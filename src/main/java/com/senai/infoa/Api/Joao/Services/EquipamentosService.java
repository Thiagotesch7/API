package com.senai.infoa.Api.Joao.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.Api.Joao.models.Equipamentos;
import com.senai.infoa.Api.Joao.repositories.EquipamentoRepository;

@Service
public class EquipamentosService {
    
    @Autowired
    private EquipamentoRepository equipamentosRepository;


    public void CadastrarEquipamento (Equipamentos equipamentos) {
        equipamentosRepository.saveAndFlush(equipamentos);
    }

    public List<Equipamentos> ListarEquipamentos () {
        return equipamentosRepository.findAll();
    }

    public void AtualizarEquipamento (Integer id, Equipamentos equipamento) {
        Equipamentos equipamentoAntigo = equipamentosRepository.findById(id).orElseThrow(()-> new RuntimeException("Não existe esse equipamento"));
        if (equipamento.getNomeEquipamento() != null) {equipamentoAntigo.setNomeEquipamento(equipamento.getNomeEquipamento());}
    }

    public void DeletarEquipamentoId (Integer id) {
        equipamentosRepository.deleteById(id);
    }

    
}
