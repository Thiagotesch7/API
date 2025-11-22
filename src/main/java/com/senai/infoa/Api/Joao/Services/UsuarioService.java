package com.senai.infoa.Api.Joao.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.Api.Joao.models.Usuario;
import com.senai.infoa.Api.Joao.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void CadastrarUsuario (Usuario usuario) {
        usuarioRepository.saveAndFlush(usuario);
    }

    public Usuario LoginUsuario (String nomeUsuario, String senha) {
        return usuarioRepository.LoginUsuario(nomeUsuario, senha);
    }
   

}
