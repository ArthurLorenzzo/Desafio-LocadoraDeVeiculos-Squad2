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

    @Column
    private String placa;
    @Column
    private String chassi;
    @Column
    private String cor;
    @Column
    private BigDecimal valorTotal;

    @ManyToMany
    @JoinColumn(name = "acessorios_id")
    private List<Acessorio> acessorios;

    @OneToMany
    @JoinColumn(name = "modelo_id")
    private ModeloCarro modelo;

}