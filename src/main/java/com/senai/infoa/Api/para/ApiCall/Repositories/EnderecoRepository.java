package com.senai.infoa.Api.para.ApiCall.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.infoa.Api.para.ApiCall.Models.Endereco;

@Repository
public interface  EnderecoRepository extends JpaRepository<Endereco, Integer>{
    
}
