package com.squad2.Locadoraveiculos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
public class Motorista extends Pessoa {

    private String numeroCNH;

    @OneToMany
    private List<Aluguel> alugueis;

    public Motorista() {
    }

    public Motorista(String nome, Date dataDeNascimento, String cpf, Sexo sexo, String numeroCNH, List<Aluguel> alugueis) {
        super(nome, dataDeNascimento, cpf, sexo);
        this.numeroCNH = numeroCNH;
        this.alugueis = alugueis;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }
}
