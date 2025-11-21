package com.senai.infoa.Api.Joao.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.Api.Joao.models.Reserva;
import com.senai.infoa.Api.Joao.repositories.ReservaRepository;

@Service
public class ReservaService {
    
    @Autowired
    private ReservaRepository reservaRepository;

    public void CadastrarReserva (Reserva reserva) {
        reservaRepository.saveAndFlush(reserva);
    }
    
    public List<Reserva> ListarReservasUsuario (Integer id_usuario) {
        return reservaRepository.BuscarReservasUsuario(id_usuario);
    }
    
    

    //public List<Reserva> ListarReservasMaquinas (Integer id_equipamento) {
        //return reservaRepository.findByEquipamentosId(id_equipamento);  //RESOLVER PARA PUXAR TODOS AS RESERVAR DAQUELA MAQUINA
    

    public void DeletarReserva (Integer id_reserva) {
        reservaRepository.deleteById(id_reserva);
    }





}
