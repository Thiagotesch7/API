package senai.api.projetoApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.api.projetoApi.models.Endereco;

@Service
public class EnderecoService {

    @Autowired
    private senai.api.projetoApi.repositories.EnderecoRepository enderecoRepository;

    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}