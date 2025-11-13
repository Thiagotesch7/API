package senai.api.projetoApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.api.projetoApi.models.Usuario;
import senai.api.projetoApi.repositories.UsuarioRepository;

import java.util.Optional;

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

    @SuppressWarnings("null")
    public boolean atualizar(Integer id, Usuario usuarioAtualizado) {
        if (id == null) return false;

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            if (usuarioAtualizado.getNome() != null)
                usuario.setNome(usuarioAtualizado.getNome());

            if (usuarioAtualizado.getEmail() != null)
                usuario.setEmail(usuarioAtualizado.getEmail());

            if (usuarioAtualizado.getSenha() != null)
                usuario.setSenha(usuarioAtualizado.getSenha());

            if (usuarioAtualizado.getCpf() != null)
                usuario.setCpf(usuarioAtualizado.getCpf());

            usuarioRepository.save(usuario);
            return true;
        }

        return false;
    }
}
