package com.senai.infoa.Api.para.ApiCall.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.Api.para.ApiCall.Models.Usuario;
import com.senai.infoa.Api.para.ApiCall.Repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void cadastrarUsuario (Usuario usuario) {
        usuarioRepository.saveAndFlush(usuario);
    }

    
}
