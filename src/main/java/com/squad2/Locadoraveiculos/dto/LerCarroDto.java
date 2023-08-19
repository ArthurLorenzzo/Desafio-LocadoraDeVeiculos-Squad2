package com.squad2.Locadoraveiculos.dto;
import com.squad2.Locadoraveiculos.models.Acessorio;
import com.squad2.Locadoraveiculos.models.ModeloCarro;
import lombok.Builder;
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

    private List<Acessorio> acessorios;

    private ModeloCarro modeloCarro;
}
