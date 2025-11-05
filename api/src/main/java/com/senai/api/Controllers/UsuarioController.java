package com.senai.api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.senai.api.Models.Usuario;
import com.senai.api.Services.UsuarioService;

@RestController
@RequestMapping("Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public String cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.cadastrar(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        boolean autenticado = usuarioService.login(usuario.getEmail(), usuario.getSenha());
        if (autenticado) {
            return "Login realizado com sucesso!";
        } else {
            return "E-mail ou senha inválidos.";
        }
    }
}
