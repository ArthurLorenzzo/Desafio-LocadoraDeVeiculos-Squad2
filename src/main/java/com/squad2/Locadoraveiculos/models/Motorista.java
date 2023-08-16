package com.squad2.Locadoraveiculos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Motorista extends Pessoa {

    private String numeroCNH;

    @OneToMany
    private List<Aluguel> alugueis;

}