package com.squad2.Locadoraveiculos.dtos.acessorioDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.squad2.Locadoraveiculos.models.Carro;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class AcessorioDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String descricao;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnoreProperties("acessorios")
    private List<Carro> carros;

}
