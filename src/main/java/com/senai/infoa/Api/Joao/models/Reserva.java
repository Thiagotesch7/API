package com.senai.infoa.Api.Joao.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="id_reserva")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_maquina")
    private Maquina maquina;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @Column(name="data_inicio")
    private LocalDate dataInicio;

    @Column (name="data_final")
    private LocalDate dataFinal;

    public Reserva() {
    }

    public Reserva(Integer id, Usuario usuario, LocalDate dataInicio, LocalDate dataFinal) {
        this.id = id;

        this.usuario = usuario;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    

    public Reserva(Maquina maquina) {
        this.maquina = maquina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    

    
    
}
