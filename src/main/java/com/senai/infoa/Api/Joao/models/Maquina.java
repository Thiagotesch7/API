package com.senai.infoa.Api.Joao.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="maquina")
public class Maquina {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_maquina")
    private Integer idMaquina;

    @Column(name="nome_maquina")
    private String nomeMaquina;

    @ManyToOne
    private Reserva reserva;

    public Maquina() {
    }

    public Maquina(Integer idMaquina, String nomeMaquina) {
        this.idMaquina = idMaquina;
        this.nomeMaquina = nomeMaquina;
    }

    public Maquina(Reserva reserva) {
        this.reserva = reserva;
    }

    

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    

}
