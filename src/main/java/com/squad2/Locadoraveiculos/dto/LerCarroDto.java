package com.squad2.Locadoraveiculos.dto;

import java.math.BigDecimal;
import java.util.List;

public class LerCarroDto {

    private Long id;

    private String placa;

    private String chassi;

    private String cor;

    private BigDecimal valorDiaria;

    private List<Long> listaDeAcessoriosId;

    private Long modeloCarroId;
}
