package com.senai.infoa.Api.Joao.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @OneToMany
    @JsonIgnore
    private List<Reserva> reservas;

    public Maquina() {
    }

    public Maquina(Integer idMaquina, String nomeMaquina) {
        this.idMaquina = idMaquina;
        this.nomeMaquina = nomeMaquina;
    }

    

    

    public Maquina(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

   

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    

}
