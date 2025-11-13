package senai.api.projetoApi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.api.projetoApi.models.Endereco;
import senai.api.projetoApi.models.Usuario;
import senai.api.projetoApi.repositories.EnderecoRepository;
import senai.api.projetoApi.repositories.UsuarioRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Lista todos os endereços
    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    // Salva o endereço e vincula ao usuário existente
    public Endereco salvar(Endereco endereco) {
        if (endereco.getUsuario() != null && endereco.getUsuario().getId() != null) {
            Usuario usuario = usuarioRepository.findById(endereco.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            endereco.setUsuario(usuario);
        }
        return enderecoRepository.save(endereco);
    }

    // Busca um endereço pelo CEP
    public Endereco buscarPorCep(String cep) {
        return enderecoRepository.findByCep(cep);
    }
}
