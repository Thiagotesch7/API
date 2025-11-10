package senai.api.projetoApi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.api.projetoApi.models.Usuario;
import senai.api.projetoApi.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String cadastrar(Usuario usuario, String confirmarSenha) {
        if (usuario.getSenha() == null || confirmarSenha == null ||
            !usuario.getSenha().equals(confirmarSenha)) {
            return "Erro: As senhas não conferem.";
        }

        if (usuarioRepository.findByEmail(usuario.getEmail()) != null ||
            usuarioRepository.findByCpf(usuario.getCpf()) != null) {
            return "Erro: e-mail ou CPF já cadastrado.";
        }

        usuarioRepository.save(usuario);
        return "Usuário cadastrado com sucesso!";
    }

    public boolean login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario != null && usuario.getSenha().equals(senha);
    }

    // ✅ Novo método de atualização
    public boolean atualizar(Long id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(null);
        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();

            // Atualizando os campos que podem ser alterados
            if (usuarioAtualizado.getNome() != null) usuario.setNome(usuarioAtualizado.getNome());
            if (usuarioAtualizado.getEmail() != null) usuario.setEmail(usuarioAtualizado.getEmail());
            if (usuarioAtualizado.getSenha() != null) usuario.setSenha(usuarioAtualizado.getSenha());
            // Adicione outros campos que precisar atualizar

            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }
}
