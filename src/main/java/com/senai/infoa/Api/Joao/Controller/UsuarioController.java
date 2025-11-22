package com.senai.infoa.Api.Joao.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.Api.Joao.Services.UsuarioService;
import com.senai.infoa.Api.Joao.models.Usuario;



@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

        @PostMapping("/Cadastrar")
        public ResponseEntity<String> CadastrarUsuario (@RequestBody Usuario usuario) {
        usuarioService.CadastrarUsuario(usuario);
        return ResponseEntity.ok("Usuario Cadastrado Com Sucesso!!");}


        @PostMapping("/Login")
        public ResponseEntity<String> LoginUsuario (@RequestParam String nomeUsuario, @RequestParam String senha) {
            usuarioService.LoginUsuario(nomeUsuario, senha);
            return ResponseEntity.ok("Login efetuado!!");
        }


    }
