package com.squad2.Locadoraveiculos.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CriarCarroDTO {

    private String placa;

    private String chassi;

    private String cor;

    private BigDecimal valorDiaria;

    private List<Long> listaDeAcessoriosId;

    private Long modeloCarroId;

}
