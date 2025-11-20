package com.senai.infoa.Api.Joao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senai.infoa.Api.Joao.models.Reserva;

@Repository
public interface  ReservaRepository extends JpaRepository<Reserva, Integer>{
    
    @Query(value="SELECT * FROM reserva WHERE usuario_id = :id",nativeQuery=true)
    public List<Reserva> BuscarReservasUsuario (@Param("id")Integer id);

    }

