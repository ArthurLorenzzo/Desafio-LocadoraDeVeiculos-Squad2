package com.squad2.Locadoraveiculos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    private String nome;

    @Column
    @NotNull
    private Date dataDeNascimento;

    @Column
    @NotNull
    private String cpf;

    @Column(unique = true)
    @NotNull
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

}