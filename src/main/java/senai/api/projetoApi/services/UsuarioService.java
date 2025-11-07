package senai.api.projetoApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.api.projetoApi.models.Usuario;
import senai.api.projetoApi.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String cadastrar(Usuario usuario, String confirmarSenha) {

        // 1. Validação de senha
        if (usuario.getSenha() == null || confirmarSenha == null ||
            !usuario.getSenha().equals(confirmarSenha)) {
            return "Erro: As senhas não conferem.";
        }

        // 2. Validação de duplicidade
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null ||
            usuarioRepository.findByCpf(usuario.getCpf()) != null) {
            return "Erro: e-mail ou CPF já cadastrado.";
        }

        // 3. Sucesso
        usuarioRepository.save(usuario);
        return "Usuário cadastrado com sucesso!";
    }

    public boolean login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario != null && usuario.getSenha().equals(senha);
    }
}
