package com.squad2.Locadoraveiculos.repositories;

import com.squad2.Locadoraveiculos.models.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {


}
