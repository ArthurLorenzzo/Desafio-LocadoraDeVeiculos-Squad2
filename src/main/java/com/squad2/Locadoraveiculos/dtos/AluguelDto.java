package com.squad2.Locadoraveiculos.dtos;

import com.squad2.Locadoraveiculos.models.Carro;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class AluguelDto {



    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate dataPedido;

    private Date dataEntrega;

    private Date dataDevolucao;

    private BigDecimal valorTotal;

    private Long motorista;

    private Long apolicesSeguro;

    private List<Carro> carros;
}
