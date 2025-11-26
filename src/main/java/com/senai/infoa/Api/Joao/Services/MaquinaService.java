package com.senai.infoa.Api.Joao.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.Api.Joao.models.Maquina;
import com.senai.infoa.Api.Joao.repositories.MaquinaRepository;

@Service
public class MaquinaService {
    @Autowired
    private MaquinaRepository maquinaRepository;

    public void cadastrarMaquina (Maquina maquina) {
        maquinaRepository.saveAndFlush(maquina);
    }

    public List<Maquina> listarMaquinas () {
        return maquinaRepository.findAll();
    }

    public void atualizarMaquina (Integer idMaquina, Maquina maquina) {
        Maquina maquinaAntiga = maquinaRepository.findById(idMaquina).orElseThrow(()-> new RuntimeException("Não existe essa maquina"));

        if (maquina.getNomeMaquina() != null) {maquinaAntiga.setNomeMaquina(maquina.getNomeMaquina());}

    }

    public void deletarMaquina (Integer idMaquina) {
        maquinaRepository.deleteById(idMaquina);
    }
}

