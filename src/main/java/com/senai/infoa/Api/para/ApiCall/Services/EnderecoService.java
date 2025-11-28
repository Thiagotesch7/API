package com.senai.infoa.Api.para.ApiCall.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.Api.para.ApiCall.Models.Endereco;
import com.senai.infoa.Api.para.ApiCall.Repositories.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public void cadastrarEndereco (Endereco endereco) {
        enderecoRepository.saveAndFlush(endereco);
    }
}
