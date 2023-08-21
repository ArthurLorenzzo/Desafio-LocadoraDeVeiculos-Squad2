package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dtos.CarroDto;
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

    public List<CarroDto> retornarTodosOsCarros(){
        var carrosRecuperadosDoBanco = carroRepository.findAll();
        var listaDeRetornoDto = carrosRecuperadosDoBanco
                .stream()
                .map(carro -> {
                    var carroDto = new CarroDto();
                    BeanUtils.copyProperties(carro,carroDto);
                    return carroDto;
                }).collect(Collectors.toList());
        return listaDeRetornoDto;
    }

    public CarroDto retornarCarroPorId(long id){
        var carroRecuperadoDoBanco = retornarCarroDoBancoPorId(id);
        var CarroDto = new CarroDto();
        BeanUtils.copyProperties(carroRecuperadoDoBanco,CarroDto);
        return CarroDto;
    }
    public void deletarCarro(long id){
        var carroRecuperadoDoBanco = retornarCarroDoBancoPorId(id);
        carroRepository.delete(carroRecuperadoDoBanco);
    }
    private Carro retornarCarroDoBancoPorId(long id){
        return carroRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
