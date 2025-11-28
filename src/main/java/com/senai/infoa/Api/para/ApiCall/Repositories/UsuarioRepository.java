package com.senai.infoa.Api.para.ApiCall.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.infoa.Api.para.ApiCall.Models.Usuario;

@Repository
public interface  UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
