package com.squad2.Locadoraveiculos.services;
import com.squad2.Locadoraveiculos.dtos.aluguelDtos.CriarAluguelDto;
import com.squad2.Locadoraveiculos.dtos.aluguelDtos.LerAluguelDto;
import com.squad2.Locadoraveiculos.exceptions.ResourceNotFoundException;
import com.squad2.Locadoraveiculos.models.Aluguel;
import com.squad2.Locadoraveiculos.repositories.AluguelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class AluguelService {
    @Autowired
    private AluguelRepository aluguelRepository;

    private Logger logger = Logger.getLogger(AluguelService.class.getName());

    public CriarAluguelDto criarAluguel(CriarAluguelDto criarAluguelDTO) {

        Aluguel aluguel = new Aluguel();
        BeanUtils.copyProperties(criarAluguelDTO, aluguel, "dataPedido");
        aluguel.setDataPedido(LocalDate.now());

        aluguel = aluguelRepository.save(aluguel);

        CriarAluguelDto aluguelCriado = new CriarAluguelDto();
        BeanUtils.copyProperties(aluguel, aluguelCriado);

        return aluguelCriado;

    }

    public LerAluguelDto retornarAlugueisById (Long id) {

        logger.info("Finding one rent!");

        Aluguel aluguel = aluguelRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));

        LerAluguelDto lerAluguelDto = new LerAluguelDto();
        BeanUtils.copyProperties(aluguel, lerAluguelDto);

        return lerAluguelDto;
    }

    public List<LerAluguelDto> retornarTodosAlugueis () {

        logger.info("Finding all rents!");

        List<Aluguel> listaAluguel = aluguelRepository.findAll();
        return listaAluguel.stream()
                .map(aluguel -> {
                    LerAluguelDto lerAluguelDto = new LerAluguelDto();
                    BeanUtils.copyProperties(aluguel, lerAluguelDto);
                    return lerAluguelDto;
                })
                .collect(Collectors.toList());

    }

    public void deletarAluguel ( Long id ){

        logger.info("Deleting one rent!");

        var entity = aluguelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
        aluguelRepository.delete(entity);

    }

}
