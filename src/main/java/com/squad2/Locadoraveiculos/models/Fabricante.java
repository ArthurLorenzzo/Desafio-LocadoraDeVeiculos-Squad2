package com.squad2.Locadoraveiculos.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;
@Entity
@Data
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @OneToMany (mappedBy = "fabricante")
    private List<ModeloCarro> modelos;

}