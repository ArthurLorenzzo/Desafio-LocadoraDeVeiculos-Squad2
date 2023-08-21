package com.squad2.Locadoraveiculos.dtos.modelosCarroDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.squad2.Locadoraveiculos.models.Carro;
import com.squad2.Locadoraveiculos.models.Categoria;
import com.squad2.Locadoraveiculos.models.Fabricante;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.List;

@Data
public class LerModeloCarroDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @JsonIgnoreProperties("modelos")
    private Fabricante fabricante;


    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnoreProperties({"modeloCarro", "acessorios"})
    private List<Carro> carros;

}

