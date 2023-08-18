package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dto.CriarModeloCarroDto;
import com.squad2.Locadoraveiculos.models.ModeloCarro;
import com.squad2.Locadoraveiculos.repositories.FabricanteRepository;
import com.squad2.Locadoraveiculos.repositories.ModeloCarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ModeloCarroService {

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;
    @Autowired
    private FabricanteRepository fabricanteRepository;

    public ResponseEntity<?> criarModeloCarro(CriarModeloCarroDto modeloCarroDto){
        try{
            ModeloCarro modeloCarro = new ModeloCarro();
            BeanUtils.copyProperties(modeloCarroDto,modeloCarro,"fabricante");
            modeloCarro.setFabricante(fabricanteRepository.findById(modeloCarroDto.fabricanteId()).orElseThrow());
            modeloCarro = modeloCarroRepository.save(modeloCarro);
            return ResponseEntity.status(HttpStatus.CREATED).body(modeloCarro);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity<?> retornarTodosOsModelosCarro(){
        var fabricantesRetornados = modeloCarroRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(fabricantesRetornados);
    }

    public ModeloCarro retornarModeloCarroPorid(Long id){

        return modeloCarroRepository.findById(id).orElseThrow();
    }

}
