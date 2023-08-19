package com.squad2.Locadoraveiculos.dtos.modeloCarroDto;

import com.squad2.Locadoraveiculos.models.Categoria;

public record CriarModeloCarroDto(String descricao, Categoria categoria, Long fabricanteId) { }
