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
    private Calendar dataPedido;
    private Date dataEntrega;
    private Date dataDevolucao;
    private BigDecimal valorTotal;

    @OneToOne
    private ApoliceSeguro apoliceSeguro;

    @ManyToOne
    private List<Carro> carros = new ArrayList<>();

}
