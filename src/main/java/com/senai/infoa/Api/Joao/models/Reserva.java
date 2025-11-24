package com.senai.infoa.Api.Joao.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="id_reserva")
    private Integer id;

    @OneToMany
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

    public Reserva(Integer id, Maquina maquina, Usuario usuario, LocalDate dataInicio, LocalDate dataFinal) {
        this.id = id;
        this.maquina = maquina;
        this.usuario = usuario;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
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

    
}
