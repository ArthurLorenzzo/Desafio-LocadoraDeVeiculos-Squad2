package com.squad2.Locadoraveiculos.dto;

import com.squad2.Locadoraveiculos.models.Categoria;

public record CreateModeloCarroDto(String descricao, Categoria categoria, Long FabricanteId) { }
