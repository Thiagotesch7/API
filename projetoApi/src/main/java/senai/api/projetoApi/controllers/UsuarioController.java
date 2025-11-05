package senai.api.projetoApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import senai.api.projetoApi.models.Usuario;
import senai.api.projetoApi.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public String cadastrar(@RequestBody Usuario usuario) {
        boolean sucesso = usuarioService.cadastrar(usuario);
        return sucesso ? "Usuário cadastrado com sucesso!" : "Erro: e-mail ou CPF já cadastrado.";
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        boolean autenticado = usuarioService.login(usuario.getEmail(), usuario.getSenha());
        return autenticado ? "Login realizado com sucesso!" : "E-mail ou senha inválidos.";
    }
}
