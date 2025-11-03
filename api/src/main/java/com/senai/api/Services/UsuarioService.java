package com.senai.api.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.api.Models.Usuario;
import com.senai.api.Repositories.UsuarioRepository;


@Service
public class UsuarioService {
   @Autowired
    private UsuarioRepository usuarioRepository;

    private List<Usuario> usuarios = new ArrayList<>();
  private boolean validarSenha(String senha) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(senha);
        
        return matcher.matches(); // Retorna true se a senha for válida
    }

    public boolean cadastrar(Usuario novoUsuario) {
        if (!validarSenha(novoUsuario.getSenha())) {
            return false;
        }
        usuarioRepository.save(novoUsuario);
        return true;
    }

    public boolean login(String email, String senha) {
        for (Usuario u : usuarios) {
            if (email.equals(u.getEmail()) && senha.equals(u.getSenha())) {
                return true;
            }
        }
        return false;
    }


} 

