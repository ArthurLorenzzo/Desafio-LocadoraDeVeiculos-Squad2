package com.squad2.Locadoraveiculos.dtos.aluguelDtos;

import com.squad2.Locadoraveiculos.models.ApoliceSeguro;
import com.squad2.Locadoraveiculos.models.Carro;
import com.squad2.Locadoraveiculos.models.Motorista;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Data
public class LerAluguelDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate dataPedido;

    private Date dataEntrega;

    private Date dataDevolucao;

    private BigDecimal valorTotal;

    private Motorista motorista;

    private ApoliceSeguro apolicesSeguro;

    private List<Carro> carros;
}
