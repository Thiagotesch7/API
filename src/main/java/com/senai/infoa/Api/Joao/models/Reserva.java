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
@Table(name="reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_reserva")
    private Integer id;

    @Column(name="data_inicio")
    private LocalDate dataInicio;

    @Column(name="data_final")
    private LocalDate dataFinal;


    //@ManyToOne
    //@JoinColumn(name="usuario_id")
    //private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="equipamento_id")
    private Equipamentos equipamentos;


    public Reserva() {
    }


    public Reserva(Integer id, LocalDate dataInicio, LocalDate dataFinal, Equipamentos equipamentos) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this. equipamentos = equipamentos;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
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




    public Equipamentos getEquipamentos() {
        return equipamentos;
    }


    public void setEquipamentos(Equipamentos equipamentos) {
        this.equipamentos = equipamentos;
    }

    

    
}


