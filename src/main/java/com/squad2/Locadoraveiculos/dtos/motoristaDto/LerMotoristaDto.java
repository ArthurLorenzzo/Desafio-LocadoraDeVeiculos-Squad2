package com.squad2.Locadoraveiculos.dtos.motoristaDto;

import com.squad2.Locadoraveiculos.models.Sexo;

import java.util.Date;

public record LerMotoristaDto(String nome, Date dataDeNascimento, String cpf, String email, Sexo sexo, String numeroCNH) {
}
