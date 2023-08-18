package com.squad2.Locadoraveiculos.dto;

import com.squad2.Locadoraveiculos.models.ApoliceSeguro;
import com.squad2.Locadoraveiculos.models.Carro;
import com.squad2.Locadoraveiculos.models.Motorista;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Calendar;
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
