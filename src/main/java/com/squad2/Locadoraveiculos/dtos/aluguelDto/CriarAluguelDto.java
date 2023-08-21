package com.squad2.Locadoraveiculos.dtos.aluguelDto;

import com.squad2.Locadoraveiculos.models.ApoliceSeguro;
import com.squad2.Locadoraveiculos.models.Carro;
import com.squad2.Locadoraveiculos.models.Motorista;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class CriarAluguelDto {

    //private LocalDate dataPedido;

    private Date dataEntrega;

    private Date dataDevolucao;

    private BigDecimal valorTotal;

    private Long motorista;

    private Long apolicesSeguro;

    private List<Long> carros;
}
