package com.squad2.Locadoraveiculos.services;
import com.squad2.Locadoraveiculos.dtos.AluguelDto;
import com.squad2.Locadoraveiculos.dtos.MotoristaDto;
import com.squad2.Locadoraveiculos.exceptions.ResourceNotFoundException;
import com.squad2.Locadoraveiculos.models.Aluguel;
import com.squad2.Locadoraveiculos.models.ApoliceSeguro;
import com.squad2.Locadoraveiculos.models.Carro;
import com.squad2.Locadoraveiculos.models.Motorista;
import com.squad2.Locadoraveiculos.repositories.AluguelRepository;
import com.squad2.Locadoraveiculos.repositories.ApoliceSeguroRepository;
import com.squad2.Locadoraveiculos.repositories.CarroRepository;
import com.squad2.Locadoraveiculos.repositories.MotoristaRepository;
import jakarta.transaction.Transactional;
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

    public AluguelDto criarAluguel(AluguelDto aluguelDTO) {

        Aluguel aluguel = new Aluguel();
        BeanUtils.copyProperties(aluguelDTO, aluguel, "dataPedido");
        aluguel.setDataPedido(LocalDate.now());

        aluguel = aluguelRepository.save(aluguel);

        AluguelDto aluguelCriado = new AluguelDto();
        BeanUtils.copyProperties(aluguel, aluguelCriado);

        return aluguelCriado;

    }

    public AluguelDto retornarAlugueisById (Long id) {

        logger.info("Finding one rent!");

        Aluguel aluguel = aluguelRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));

        AluguelDto aluguelDto = new AluguelDto();
        BeanUtils.copyProperties(aluguel, aluguelDto);

        return aluguelDto;
    }

    public List<AluguelDto> retornarTodosAlugueis () {

        logger.info("Finding all rents!");

        List<Aluguel> listaAluguel = aluguelRepository.findAll();
        return listaAluguel.stream()
                .map(aluguel -> {
                    AluguelDto aluguelDto = new AluguelDto();
                    BeanUtils.copyProperties(aluguel, aluguelDto);
                    return aluguelDto;
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
