package com.senai.infoa.Api.Joao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.senai.infoa.Api.Joao.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    
    @Query(value="SELECT * FROM reserva WHERE id_usuario = :Idusuario",nativeQuery=true)
    public List<Reserva> listarReservaUsuario (@Param("idUsuario") Integer idUsuario);

    @Query(value="SELECT * FROM reserva WHERE id_maquina = :idMaquina",nativeQuery=true)
    public List<Reserva> listarReservaMaquina (@Param("idMaquina") Integer idMaquina);
}
