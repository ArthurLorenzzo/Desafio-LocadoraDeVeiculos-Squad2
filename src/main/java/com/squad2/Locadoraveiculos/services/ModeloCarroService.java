package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dtos.ModeloCarroDto;
import com.squad2.Locadoraveiculos.exceptions.ResourceNotFoundException;
import com.squad2.Locadoraveiculos.models.ModeloCarro;
import com.squad2.Locadoraveiculos.repositories.ModeloCarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloCarroService {

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    public ModeloCarroDto criarModeloCarro(ModeloCarroDto modeloCarroDto){
        ModeloCarro modeloCarro = new ModeloCarro();
        BeanUtils.copyProperties(modeloCarroDto,modeloCarro);
        modeloCarro = modeloCarroRepository.save(modeloCarro);
        BeanUtils.copyProperties(modeloCarro,modeloCarroDto);
        return modeloCarroDto;
    }

    public List<ModeloCarroDto> retornarTodosOsModelosCarro(){
        var modeloCarrosRecuperados = modeloCarroRepository.findAll();
        var modelosCarrosDto = modeloCarrosRecuperados
                .stream()
                .map(fabricante -> {
                 var modeloCarroDto = new ModeloCarroDto();
                 BeanUtils.copyProperties(fabricante,modeloCarroDto);
                 return modeloCarroDto;
                })
                .toList();
        return modelosCarrosDto;
    }

    public ModeloCarroDto retornarModeloCarroPorid(Long id){
        var modeloCarroRecuperado = recuperarModeloCarroPorId(id);
        var modeloCarroDto = new ModeloCarroDto();
        BeanUtils.copyProperties(modeloCarroRecuperado,modeloCarroDto);
        return modeloCarroDto;
    }

    public void deletarModeloCarroPorId(Long id){
        var modeloCarroRecuperado = recuperarModeloCarroPorId(id);
        modeloCarroRepository.delete(modeloCarroRecuperado);
    }

    private ModeloCarro recuperarModeloCarroPorId(Long id) {
        return modeloCarroRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }


}
