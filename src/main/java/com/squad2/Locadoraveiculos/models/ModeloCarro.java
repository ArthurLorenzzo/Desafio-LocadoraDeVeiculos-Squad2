package com.squad2.Locadoraveiculos.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;
@Entity
@Data
public class ModeloCarro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String descricao;

    //Nao necessita annotation
    private Categoria categoria;

    @OneToMany
    private Fabricante fabricante;

}