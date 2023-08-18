package com.squad2.Locadoraveiculos.repositories;

import com.squad2.Locadoraveiculos.models.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    @Query("SELECT a FROM Aluguel a " +
            "WHERE (a.dataEntrega BETWEEN :startDate AND :endDate) OR " +
            "(a.dataDevolucao BETWEEN :startDate AND :endDate) OR " +
            "(:startDate BETWEEN a.dataEntrega AND a.dataDevolucao) OR " +
            "(:endDate BETWEEN a.dataEntrega AND a.dataDevolucao)")
    List<Aluguel> findByDateRange(Date startDate, Date endDate);

}
