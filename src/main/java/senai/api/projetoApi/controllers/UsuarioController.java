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

    /**
     * Cadastra um novo usuário.
     * Recebe os dados do usuário via JSON (request body)
     * e a confirmação de senha como parâmetro separado.
     */
    @PostMapping("/cadastro")
    public String cadastrar(
            @RequestBody Usuario usuario,
            @RequestParam("confirmarSenha") String confirmarSenha) {

        return usuarioService.cadastrar(usuario, confirmarSenha);
    }

    /**
     * Realiza o login do usuário.
     * Agora recebe e-mail e senha via parâmetros (RequestParam).
     */
    @PostMapping("/login")
    public String login(
            @Parameter(description = "E-mail do usuário", example = "joao@email.com")
            @RequestParam("email") String email,

            @Parameter(description = "Senha do usuário", example = "123456")
            @RequestParam("senha") String senha) {

        boolean autenticado = usuarioService.login(email, senha);
        return autenticado ? "Login realizado com sucesso!" : "E-mail ou senha inválidos.";
    }
}
