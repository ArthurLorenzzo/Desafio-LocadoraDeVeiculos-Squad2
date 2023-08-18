package com.squad2.Locadoraveiculos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descricao;

    @ManyToMany(mappedBy = "acessorios")
    @JsonManagedReference
    @JsonIgnore
    private List<Carro> carros;

}