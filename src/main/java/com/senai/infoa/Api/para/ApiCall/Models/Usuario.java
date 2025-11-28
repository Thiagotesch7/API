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
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Integer idUsuario;

    @Column(name="nome_completo")
    private String nomeCompleto;

    @Column(name="cpf")
    private String cpf;

    @Column(name="email")
    private String email;

    @Column(name="senha")
    private String senha;


}
