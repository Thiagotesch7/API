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

    public void cadastrarReserva (Reserva reserva) {
        reservaRepository.saveAndFlush(reserva);
    }

    public List<Reserva> listarReservasDoUsuario (Integer idUsuario) {
        return reservaRepository.listarReservaUsuario(idUsuario);
    }

    public List<Reserva> listarReservasDaMaquina (Integer idMaquina) {
        return reservaRepository.listarReservaMaquina(idMaquina);
    }

    public void deletarReserva (Integer id) {
        reservaRepository.deleteById(id);
    }


}
