package senai.api.projetoApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Parameter;
import senai.api.projetoApi.models.Usuario;
import senai.api.projetoApi.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public String cadastrar(
            @RequestBody Usuario usuario,
            @RequestParam("confirmarSenha") String confirmarSenha) {

        return usuarioService.cadastrar(usuario, confirmarSenha);
    }

    @PostMapping("/login")
    public String login(
            @Parameter(description = "E-mail do usuário", example = "joao@email.com")
            @RequestParam("email") String email,

            @Parameter(description = "Senha do usuário", example = "123456")
            @RequestParam("senha") String senha) {

        boolean autenticado = usuarioService.login(email, senha);
        return autenticado ? "Login realizado com sucesso!" : "E-mail ou senha inválidos.";
    }

    @PutMapping("/{id}")
    public String atualizarUsuario(
            @PathVariable Long id,
            @RequestBody Usuario usuarioAtualizado) {

        boolean atualizado = usuarioService.atualizar(id, usuarioAtualizado);
        return atualizado ? "Usuário atualizado com sucesso!" : "Falha ao atualizar usuário.";
    }
}
