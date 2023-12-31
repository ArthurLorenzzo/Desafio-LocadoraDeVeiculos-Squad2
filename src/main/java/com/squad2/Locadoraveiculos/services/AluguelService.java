package com.squad2.Locadoraveiculos.services;
import com.squad2.Locadoraveiculos.dtos.aluguelDtos.CriarAluguelDto;
import com.squad2.Locadoraveiculos.dtos.aluguelDtos.LerAluguelDto;
import com.squad2.Locadoraveiculos.exceptions.ResourceNotFoundException;
import com.squad2.Locadoraveiculos.models.Acessorio;
import com.squad2.Locadoraveiculos.models.Aluguel;
import com.squad2.Locadoraveiculos.models.Carro;
import com.squad2.Locadoraveiculos.repositories.AluguelRepository;
import com.squad2.Locadoraveiculos.repositories.ApoliceSeguroRepository;
import com.squad2.Locadoraveiculos.repositories.CarroRepository;
import com.squad2.Locadoraveiculos.repositories.MotoristaRepository;
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

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    private Logger logger = Logger.getLogger(AluguelService.class.getName());

    public LerAluguelDto criarAluguel(CriarAluguelDto criarAluguelDTO) {

        Aluguel aluguelCriado = new Aluguel();
        BeanUtils.copyProperties(criarAluguelDTO, aluguelCriado, "dataPedido", "motorista_id", "apolicesSeguro_id", "carros_id");
        aluguelCriado.setDataPedido(LocalDate.now());

        aluguelCriado.setMotorista(motoristaRepository.findById(criarAluguelDTO.getMotorista_id())
                .orElseThrow(ResourceNotFoundException::new));

        aluguelCriado.setApoliceSeguro(apoliceSeguroRepository.findById(criarAluguelDTO.getApolicesSeguro_id())
                .orElseThrow(ResourceNotFoundException::new));

        List<Carro> listaCarro = criarAluguelDTO
                .getCarros_id()
                .stream()
                .map(idCarro -> {
                        var carro = carroRepository.findById(idCarro)
                                .orElseThrow(ResourceNotFoundException::new);
                        return carro;
                }).toList();
        aluguelCriado.setCarros(listaCarro);

        LerAluguelDto lerAluguelDto = new LerAluguelDto();
        aluguelCriado = aluguelRepository.save(aluguelCriado);
        BeanUtils.copyProperties(aluguelCriado, lerAluguelDto);
        return lerAluguelDto;

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
