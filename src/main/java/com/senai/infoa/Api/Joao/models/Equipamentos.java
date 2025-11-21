package com.senai.infoa.Api.Joao.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity

@Table(name = "equipamentos")
public class Equipamentos {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_equipamento")
    private Integer id;

    @Column(name="nome_equipamento")
    private String nomeEquipamento;

    @OneToOne(mappedBy="equipamentos")
    private Reserva reserva;

    public Equipamentos() {
    }

    public Equipamentos(Integer id, String nomeEquipamento, Reserva reserva) {
        this.id = id;
        this.nomeEquipamento = nomeEquipamento;
        this.reserva = reserva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }


    
    

}

