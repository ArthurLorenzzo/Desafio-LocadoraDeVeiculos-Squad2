package com.squad2.Locadoraveiculos.dtos.motoristaDto;

import com.squad2.Locadoraveiculos.models.Sexo;
import lombok.Data;

import java.util.Date;

@Data
public class MotoristaDto {

    private Long id;
    private String nome;
    private Date dataDeNascimento;
    private String cpf;
    private String email;
    private Sexo sexo;
    private String numeroCNH;
}
