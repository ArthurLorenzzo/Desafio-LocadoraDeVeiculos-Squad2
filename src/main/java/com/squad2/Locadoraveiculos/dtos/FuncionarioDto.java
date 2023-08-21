package com.squad2.Locadoraveiculos.dtos;

import com.squad2.Locadoraveiculos.models.Sexo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
@Data
public class FuncionarioDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String nome;
    private Date dataDeNascimento;
    private String cpf;
    private String email;
    private Sexo sexo;
    private String matricula;
}
