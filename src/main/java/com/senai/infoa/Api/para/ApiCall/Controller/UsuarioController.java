package com.senai.infoa.Api.para.ApiCall.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.Api.para.ApiCall.Models.Usuario;
import com.senai.infoa.Api.para.ApiCall.Services.UsuarioService;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    public ResponseEntity<String> cadastrarUsuario (@RequestBody Usuario usuario) {
        usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok("Cadastrado com Sucesso");
    }
}
