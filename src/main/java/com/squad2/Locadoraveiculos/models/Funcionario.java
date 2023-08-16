package com.squad2.Locadoraveiculos.models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class Funcionario extends Pessoa {

    private String matricula;

}