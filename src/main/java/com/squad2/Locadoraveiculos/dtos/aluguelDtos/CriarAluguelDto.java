package com.squad2.Locadoraveiculos.dtos.aluguelDtos;

import com.squad2.Locadoraveiculos.models.Carro;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class CriarAluguelDto {


    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate dataPedido;

    private Date dataEntrega;

    private Date dataDevolucao;

    private BigDecimal valorTotal;

    private Long motorista_id;

    private Long apolicesSeguro_id;

    private List<Long> carros_id;
}
