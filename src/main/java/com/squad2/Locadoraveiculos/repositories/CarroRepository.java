package com.squad2.Locadoraveiculos.repositories;

import com.squad2.Locadoraveiculos.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
