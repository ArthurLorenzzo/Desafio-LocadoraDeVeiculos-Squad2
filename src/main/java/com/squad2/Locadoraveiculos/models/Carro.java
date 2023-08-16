package com.squad2.Locadoraveiculos.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
@Entity
@Data
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorTotal;

    @ManyToMany
    private List<Acessorio> acessorios;

    @OneToMany
    private ModeloCarro modelo;

}