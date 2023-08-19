package com.squad2.Locadoraveiculos.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @OneToMany (mappedBy = "fabricante")
    @JsonIgnoreProperties("fabricante")
    private List<ModeloCarro> modelos;

}