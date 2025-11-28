package com.senai.infoa.Api.para.ApiCall.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_endereco")
    private Integer idEndereco;

    @Column(name="rua")
    private String rua;

    @Column(name="numero")
    private String numero;

    @Column(name="complemento")
    private String complemento;

    @Column(name="bairro")
    private String bairro;

    @Column(name="cep")
    private String cep;

    @Column(name="cidade")
    private String cidade;

    @Column(name="estado")
    private String estado;
}
