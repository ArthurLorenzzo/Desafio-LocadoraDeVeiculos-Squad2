package com.squad2.Locadoraveiculos.repositories;

import com.squad2.Locadoraveiculos.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
