package senai.api.projetoApi.controllers;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Parameter;
import senai.api.projetoApi.models.Usuario;
import senai.api.projetoApi.repositories.UsuarioRepository;
import senai.api.projetoApi.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

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
    public String atualizar(
            @PathVariable Integer id,
            @RequestBody Usuario usuarioAtualizado) {
        boolean atualizado = usuarioService.atualizar(id, usuarioAtualizado);
        return atualizado ? "Usuário atualizado com sucesso!" : "Falha ao atualizar usuário.";
    }

    @GetMapping("/{id}")
    public Object buscarPorId(@PathVariable Integer id) {
        if (id == null) return false;
        return usuarioRepository.findById(id)
                .<Object>map(usuario -> usuario)
                .orElse("Usuário não encontrado.");
    }
}
