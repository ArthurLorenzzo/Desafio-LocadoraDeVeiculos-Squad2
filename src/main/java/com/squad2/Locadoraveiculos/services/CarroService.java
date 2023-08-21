package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dtos.carroDtos.CarroDto;
import com.squad2.Locadoraveiculos.dtos.carroDtos.LerCarroDto;
import com.squad2.Locadoraveiculos.exceptions.RequiredObjectIsNullException;
import com.squad2.Locadoraveiculos.exceptions.ResourceNotFoundException;
import com.squad2.Locadoraveiculos.models.Carro;
import com.squad2.Locadoraveiculos.repositories.CarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;


    public CarroDto criarCarro(CarroDto carroDTO) {
        if (carroDTO == null){throw new RequiredObjectIsNullException();}
        var carroCriado = new Carro();
        BeanUtils.copyProperties(carroDTO,carroCriado);
        carroCriado = carroRepository.save(carroCriado);
        BeanUtils.copyProperties(carroCriado,carroDTO);
        return carroDTO;
    }

    public List<LerCarroDto> retornarTodosOsCarros(){
        var carrosRecuperadosDoBanco = carroRepository.findAll();
        var listaDeRetornoDto = carrosRecuperadosDoBanco
                .stream()
                .map(carro -> {
                    var carroDto = new LerCarroDto();
                    BeanUtils.copyProperties(carro,carroDto);
                    return carroDto;
                }).collect(Collectors.toList());
        return listaDeRetornoDto;
    }

    public LerCarroDto retornarCarroPorId(long id){
        var carroRecuperadoDoBanco = retornarCarroDoBancoPorId(id);
        var carroDto = new LerCarroDto();
        BeanUtils.copyProperties(carroRecuperadoDoBanco, carroDto);
        return carroDto;
    }
    public void deletarCarro(long id){
        var carroRecuperadoDoBanco = retornarCarroDoBancoPorId(id);
        carroRepository.delete(carroRecuperadoDoBanco);
    }
    private Carro retornarCarroDoBancoPorId(long id){
        return carroRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
