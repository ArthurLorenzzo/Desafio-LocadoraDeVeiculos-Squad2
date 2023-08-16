package com.squad2.Locadoraveiculos.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;
@Entity
@Data
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "carro_id")
    private List<Carro> carros;

}