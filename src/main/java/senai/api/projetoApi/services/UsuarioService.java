package senai.api.projetoApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.api.projetoApi.models.Usuario;
import senai.api.projetoApi.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * O método recebe o objeto usuário e a senha de confirmação.
     * O retorno foi alterado para String para dar mensagens de erro específicas.
     */
    public String cadastrar(Usuario usuario, String confirmarSenha) {
        
        // 1. VALIDAÇÃO DE SENHA
        if (usuario.getSenha() == null || confirmarSenha == null || 
            !usuario.getSenha().equals(confirmarSenha)) {
            
            return "Erro: As senhas não conferem.";
        }

        // 2. VALIDAÇÃO DE DUPLICIDADE
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null ||
            usuarioRepository.findByCpf(usuario.getCpf()) != null) {
            
            return "Erro: e-mail ou CPF já cadastrado.";
        }

        // 3. SUCESSO
        usuarioRepository.save(usuario);
        return "Usuário cadastrado com sucesso!";
    }

    public boolean login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario != null && usuario.getSenha().equals(senha);
    }
}
