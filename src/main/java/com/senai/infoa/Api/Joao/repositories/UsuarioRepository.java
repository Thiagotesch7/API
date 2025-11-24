package com.senai.infoa.Api.Joao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senai.infoa.Api.Joao.models.Usuario;

@Repository
public interface  UsuarioRepository extends JpaRepository<Usuario, Integer>{
   
   @Query(value="SELECT * FROM usuario WHERE nome_usuario = :nome_usuario AND senha = :senha",nativeQuery=true)
   public Usuario LoginUsuario (@Param ("nome_usuario") String nomeUsuario, @Param("senha")String senha);
}
