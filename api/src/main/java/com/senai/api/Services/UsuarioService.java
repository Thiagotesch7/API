package com.senai.api.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.api.Models.Usuario;
import com.senai.api.Repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Cadastro de usuário simplificado
    public String cadastrar(Usuario novoUsuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(novoUsuario.getEmail());
        if (usuarioExistente.isPresent()) {
            return "E-mail já cadastrado!";
        }

        // Apenas salva o usuário sem validar senha
        usuarioRepository.save(novoUsuario);
        return "Usuário cadastrado com sucesso!";
    }

    // Login simples
    public boolean login(String email, String senha) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario.isPresent() && usuario.get().getSenha().equals(senha);
    }
}
