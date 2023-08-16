package com.squad2.Locadoraveiculos.repositories;

import com.squad2.Locadoraveiculos.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
