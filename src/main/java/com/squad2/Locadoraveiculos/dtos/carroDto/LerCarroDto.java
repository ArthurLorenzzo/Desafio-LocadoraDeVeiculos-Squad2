package com.squad2.Locadoraveiculos.dtos.carroDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.squad2.Locadoraveiculos.models.Acessorio;
import com.squad2.Locadoraveiculos.models.ModeloCarro;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class LerCarroDto {

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
