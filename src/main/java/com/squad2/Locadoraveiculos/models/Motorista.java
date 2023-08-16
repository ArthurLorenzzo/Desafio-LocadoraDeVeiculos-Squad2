package com.squad2.Locadoraveiculos.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Motorista extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String numeroCNH;

    @OneToMany
    @JoinColumn(name = "alugueis_id")
    private List<Aluguel> alugueis;

}