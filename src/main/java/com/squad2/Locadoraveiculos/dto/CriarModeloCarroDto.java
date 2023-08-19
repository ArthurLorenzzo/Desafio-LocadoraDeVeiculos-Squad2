package com.squad2.Locadoraveiculos.dto;

import com.squad2.Locadoraveiculos.models.Categoria;

public record CriarModeloCarroDto(String descricao, Categoria categoria, Long fabricanteId) { }
