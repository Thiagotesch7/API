package com.senai.infoa.Api.Joao.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.Api.Joao.Services.ReservaService;
import com.senai.infoa.Api.Joao.models.Reserva;



@RestController
@RequestMapping("/Reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping("/Cadastrar")
    public ResponseEntity<String> cadastrarReserva(@RequestBody Reserva reserva) {
        reservaService.CadastrarReserva(reserva);
        return ResponseEntity.ok("Reserva Feita Com Sucesso!!");
    }

   @GetMapping("/ListarReservaUsuario")
   public List<Reserva> listarResercaDoUsuario(@RequestParam Integer id) {
    return reservaService.ListarReservasUsuario(id);
    }
    
    //@GetMapping("/ListarReservaEquipamento")
    //public List<Reserva> listarReservaDoEquipamento(@RequestParam Integer equipamento_id) {
      //  return reservaService.ListarReservasMaquinas(equipamento_id);
    
    
}
