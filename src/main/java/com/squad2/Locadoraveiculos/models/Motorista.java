package com.squad2.Locadoraveiculos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Motorista extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String numeroCNH;

    @OneToMany(mappedBy = "motorista")
    @JsonIgnoreProperties("motorista")
    private List<Aluguel> alugueis;
}