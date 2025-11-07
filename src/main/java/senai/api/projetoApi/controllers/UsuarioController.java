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
    public String cadastrar(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("cpf") String cpf,
            @RequestParam("senha") String senha,
            @RequestParam("confirmarSenha") String confirmarSenha) {
        
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setCpf(cpf);
        usuario.setSenha(senha);

        return usuarioService.cadastrar(usuario, confirmarSenha);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        boolean autenticado = usuarioService.login(usuario.getEmail(), usuario.getSenha());
        return autenticado ? "Login realizado com sucesso!" : "E-mail ou senha inválidos.";
    }
}
