package com.squad2.Locadoraveiculos.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
@Entity
@Table(name = "aluguel")
@Data
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private LocalDate dataPedido;
    @Column
    private Date dataEntrega;
    @Column
    private Date dataDevolucao;
    @Column
    private BigDecimal valorTotal;


    @ManyToOne
    @JoinColumn(name = "motorista_id", nullable = false)
    @JsonIgnore
    private Motorista motorista;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apolice_seguro_id", referencedColumnName = "id")
    private ApoliceSeguro apoliceSeguro;

    @OneToMany(mappedBy = "aluguel")
    private List<Carro> carros = new ArrayList<>();

}
