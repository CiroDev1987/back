package com.back.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = " NOME ")
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }


//    @Column(name = "VALIDAÇÃO")
//    private String validacao;
//
//    @Column(name = "PERMISSÃO")
//    private String permissao;


}
