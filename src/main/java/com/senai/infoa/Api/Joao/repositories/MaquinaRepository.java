package com.senai.infoa.Api.Joao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.infoa.Api.Joao.models.Maquina;

@Repository
public interface  MaquinaRepository extends JpaRepository<Maquina, Integer>{
    
}
