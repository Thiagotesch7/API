package senai.api.projetoApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import senai.api.projetoApi.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
  Endereco findByCep(String cep);
}

