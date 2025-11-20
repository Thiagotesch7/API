package com.senai.infoa.Api.Joao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.infoa.Api.Joao.models.Equipamentos;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamentos, Integer>{
    
}
