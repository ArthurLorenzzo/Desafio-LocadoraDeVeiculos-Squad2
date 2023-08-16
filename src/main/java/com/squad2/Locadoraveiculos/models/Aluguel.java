package com.squad2.Locadoraveiculos.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.*;
@Entity
@Data
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Calendar dataPedido;
    @Column
    private Date dataEntrega;
    @Column
    private Date dataDevolucao;

    @Column
    private BigDecimal valorTotal;

    @OneToOne
    @JoinColumn(name = "apoliceSeguro_id")
    private ApoliceSeguro apoliceSeguro;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private List<Carro> carros = new ArrayList<>();

}
