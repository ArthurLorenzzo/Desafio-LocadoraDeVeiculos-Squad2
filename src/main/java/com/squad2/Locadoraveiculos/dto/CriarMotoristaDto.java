package com.squad2.Locadoraveiculos.dto;

import com.squad2.Locadoraveiculos.models.Sexo;

import java.util.Date;

public record CriarMotoristaDto(String nome, Date dataDeNascimento, String cpf, String email, Sexo sexo, String numeroCNH) {
}
