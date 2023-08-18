package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dto.CriarAcessorioDto;
import com.squad2.Locadoraveiculos.dto.CriarAluguelDto;
import com.squad2.Locadoraveiculos.dto.CriarMotoristaDto;
import com.squad2.Locadoraveiculos.dto.LerMotoristaDto;
import com.squad2.Locadoraveiculos.exceptions.ResourceNotFoundException;
import com.squad2.Locadoraveiculos.models.Acessorio;
import com.squad2.Locadoraveiculos.models.Aluguel;
import com.squad2.Locadoraveiculos.models.Motorista;
import com.squad2.Locadoraveiculos.repositories.AluguelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    public ResponseEntity<Aluguel> criarAluguel(CriarAluguelDto aluguelDTO) {
        try {
            var aluguel = new Aluguel();
            BeanUtils.copyProperties(aluguelDTO, aluguel);
            var aluguelCriado = aluguelRepository.save(aluguel);
            return ResponseEntity.status(HttpStatus.CREATED).body(aluguelCriado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
