package com.squad2.Locadoraveiculos.dtos.fabricantesDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.squad2.Locadoraveiculos.models.ModeloCarro;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class LerFabricanteDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String nome;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnoreProperties("fabricante")
    private List<ModeloCarro> modelos;
}
