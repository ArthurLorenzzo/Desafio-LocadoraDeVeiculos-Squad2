package com.squad2.Locadoraveiculos.dtos.aluguelDto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class CriarAluguelDto {

    private Date dataEntrega;

    private Date dataDevolucao;

    private BigDecimal valorTotal;

    private Long motorista;

    //private Long apolicesSeguro;

    private List<Long> carros;
}
