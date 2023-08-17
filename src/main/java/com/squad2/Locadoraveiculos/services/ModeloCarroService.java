package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.controller.ModeloCarro;
import com.squad2.Locadoraveiculos.dto.CreateModeloCarroDto;
import com.squad2.Locadoraveiculos.repositories.ModeloCarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ModeloCarroService {

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;
    private FabricanteService fabricanteService;

    private ResponseEntity<?> criarModeloCarro(CreateModeloCarroDto modeloCarroDto){
        try{
            var modeloCarro = new ModeloCarro(
                    modeloCarroDto.descricao(),
                    modeloCarroDto.categoria(),
                    fabricanteService.retornarPorId(modeloCarroDto.FabricanteId())
            );
            var novoCarro = modeloCarroRepository.save(modeloCarro);

            return ResponseEntity.status(HttpStatus.CREATED).body(novoCarro);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
