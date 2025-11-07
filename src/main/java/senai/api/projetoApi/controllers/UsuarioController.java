package senai.api.projetoApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
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
            @RequestBody 
            @Schema(description = "Dados do usuário para cadastro") Usuario usuario,
            
            @Parameter(description = "Confirmação da senha digitada pelo usuário", example = "123456")
            @RequestParam("confirmarSenha") String confirmarSenha) {

        return usuarioService.cadastrar(usuario, confirmarSenha);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        boolean autenticado = usuarioService.login(usuario.getEmail(), usuario.getSenha());
        return autenticado ? "Login realizado com sucesso!" : "E-mail ou senha inválidos.";
    }
}
