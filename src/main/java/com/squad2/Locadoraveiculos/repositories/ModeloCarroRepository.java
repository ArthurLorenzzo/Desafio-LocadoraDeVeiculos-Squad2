package com.squad2.Locadoraveiculos.repositories;

import com.squad2.Locadoraveiculos.models.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
}
