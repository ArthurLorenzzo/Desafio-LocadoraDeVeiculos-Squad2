package com.squad2.Locadoraveiculos.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

public class Acessorio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "carro_id")
    private List<Carro> carros;

    public Acessorio() {
    }

    public Acessorio(String descricao, List<Carro> carros) {
        this.descricao = descricao;
        this.carros = carros;
    }

    public Acessorio(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acessorio acessorio = (Acessorio) o;
        return Objects.equals(id, acessorio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
