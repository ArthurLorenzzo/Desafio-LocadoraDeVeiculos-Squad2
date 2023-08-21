package com.squad2.Locadoraveiculos.dtos.carroDtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.squad2.Locadoraveiculos.models.Acessorio;
import com.squad2.Locadoraveiculos.models.ModeloCarro;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class LerCarroDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String placa;

    private String chassi;

    private String cor;

    private BigDecimal valorDiaria;

    @JsonIgnoreProperties({"carros"})
    private List<Acessorio> acessorios;

    @JsonIgnoreProperties({"carros"})
    private ModeloCarro modeloCarro;
}
