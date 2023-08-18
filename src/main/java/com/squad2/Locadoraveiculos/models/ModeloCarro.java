package com.squad2.Locadoraveiculos.models;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "modelo_carro")
@Data
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
    private Fabricante fabricante;

    @OneToMany(mappedBy = "modeloCarro")
    @JsonIgnore
    private List<Carro> carros;
}