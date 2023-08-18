package com.squad2.Locadoraveiculos.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Funcionario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String matricula;

}