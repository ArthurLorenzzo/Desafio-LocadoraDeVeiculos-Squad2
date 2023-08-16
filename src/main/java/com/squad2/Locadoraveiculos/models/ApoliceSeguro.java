package com.squad2.Locadoraveiculos.models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;
@Entity
@Data
public class ApoliceSeguro {

    private BigDecimal valorFranquia;
    private Boolean protecaoTerceiro;
    private Boolean protecaoCausasNaturais;
    private Boolean protecaoRoubo;

}
