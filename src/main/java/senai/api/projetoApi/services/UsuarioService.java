package senai.api.projetoApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.api.projetoApi.models.Usuario;
import senai.api.projetoApi.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean cadastrar(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null ||
            usuarioRepository.findByCpf(usuario.getCpf()) != null) {
            return false;
        }
        usuarioRepository.save(usuario);
        return true;
    }

    public boolean login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario != null && usuario.getSenha().equals(senha);
    }
}
