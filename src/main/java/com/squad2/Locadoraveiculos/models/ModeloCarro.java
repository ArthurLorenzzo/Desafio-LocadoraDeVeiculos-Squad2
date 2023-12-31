package com.squad2.Locadoraveiculos.models;



import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "modelo_carro")
@Getter
@Setter
public class ModeloCarro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String descricao;

    @Column
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fabricante_id", nullable = false)
    @JsonIgnoreProperties("modelos")
    private Fabricante fabricante;

    @OneToMany(mappedBy = "modeloCarro")
    @JsonIgnoreProperties({"modeloCarro", "acessorios"})
    private List<Carro> carros;
}