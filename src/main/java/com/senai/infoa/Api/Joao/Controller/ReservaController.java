package com.senai.infoa.Api.Joao.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.Api.Joao.Services.ReservaService;
import com.senai.infoa.Api.Joao.models.Reserva;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(name="/Reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping("/Cadastrar")
    public ResponseEntity<String> cadastrarReserva (@RequestBody Reserva reserva) {
        reservaService.cadastrarReserva(reserva);
        return ResponseEntity.ok("Reserva Cadastrada");
    }
    
    @GetMapping("/ListarReservaDoUsuario")
    public List<Reserva> listarReservaDoUsuario (@RequestParam Integer idUsuario) {
        return reservaService.listarReservasDoUsuario(idUsuario);
    }

    @GetMapping("/ListarReservaDoUsuario")
    public List<Reserva> listarReservaDaMaquina (@RequestParam Integer idMaquina) {
        return reservaService.listarReservasDaMaquina(idMaquina);
    }

    @DeleteMapping("/DeletarReserva")
    public ResponseEntity<String> deletarReserva (@RequestParam Integer id) {
        reservaService.deletarReserva(id);
        return ResponseEntity.ok("Deletado Com Sucesso");
    }
}
