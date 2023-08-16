package com.squad2.Locadoraveiculos.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Entity
@Data
public class ApoliceSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private BigDecimal valorFranquia;
    @Column
    private Boolean protecaoTerceiro;
    @Column
    private Boolean protecaoCausasNaturais;
    @Column
    private Boolean protecaoRoubo;

}
