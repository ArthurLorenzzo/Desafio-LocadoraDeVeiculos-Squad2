package com.squad2.Locadoraveiculos.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class AluguelDto {

    //private LocalDate dataPedido;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private Date dataEntrega;

    private Date dataDevolucao;

    private BigDecimal valorTotal;

    private Long motorista;

    private Long apolicesSeguro;

    private List<Long> carros;
}
