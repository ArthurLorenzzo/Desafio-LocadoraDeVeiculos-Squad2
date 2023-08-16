package com.squad2.Locadoraveiculos.models;

import java.util.Date;

public class Funcionario extends Pessoa {

    private String matricula;

    public Funcionario() {
    }

    public Funcionario(String nome, Date dataDeNascimento, String cpf, Sexo sexo, String matricula) {
        super(nome, dataDeNascimento, cpf, sexo);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
