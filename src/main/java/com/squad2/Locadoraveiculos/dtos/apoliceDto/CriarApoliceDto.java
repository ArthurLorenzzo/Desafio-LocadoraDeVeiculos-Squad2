package com.squad2.Locadoraveiculos.dtos.apoliceDto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CriarApoliceDto {

    private BigDecimal valorFranquia;

    private boolean protecaoTerceiro;

    private boolean protecaoCausasNaturais;

    private boolean protecaoRoubo;

}
