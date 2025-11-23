package com.senai.infoa.Api.Joao.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="maquina")
public class Maquina {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_maquina")
    private Integer id;

    @Column(name="nome_maquina")
    private String nomeMaquina;

    public Maquina() {
    }

    public Maquina(Integer id, String nomeMaquina) {
        this.id = id;
        this.nomeMaquina = nomeMaquina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }


}
