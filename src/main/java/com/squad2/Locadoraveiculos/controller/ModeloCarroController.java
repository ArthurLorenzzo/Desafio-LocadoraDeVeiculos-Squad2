package com.squad2.Locadoraveiculos.controller;

import com.squad2.Locadoraveiculos.dto.CriarModeloCarroDto;
import com.squad2.Locadoraveiculos.services.ModeloCarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/modelos-carros")
public class ModeloCarroController {

    @Autowired
    private ModeloCarroService modeloCarroService;

    @PostMapping
    public ResponseEntity<?> cadastrarModeloCarro(@RequestBody CriarModeloCarroDto modeloDto){
        return  modeloCarroService.criarModeloCarro(modeloDto);
    }

    @GetMapping
    public  ResponseEntity<?> retornarTodosOsModelosCarro(){
        return  modeloCarroService.retornarTodosOsModelosCarro();
    }



}
