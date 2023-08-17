package com.squad2.Locadoraveiculos.dto;

import com.squad2.Locadoraveiculos.models.Sexo;

public record LerMotoristaDto(Long id, String nome, String cpf, String email, Sexo sexo, String numeroCNH) {
}
