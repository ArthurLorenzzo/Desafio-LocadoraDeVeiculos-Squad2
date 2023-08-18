package com.squad2.Locadoraveiculos.dto;

import com.squad2.Locadoraveiculos.models.ApoliceSeguro;
import com.squad2.Locadoraveiculos.models.Carro;
import com.squad2.Locadoraveiculos.models.Motorista;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public record CriarAluguelDto (Calendar dataPedido,
                               Date dataEntrega,
                               Date dataDevolucao,
                               BigDecimal valorTotal,
                               Motorista motorista,
                               ApoliceSeguro apoliceSeguro,
                               Carro carro){
}
