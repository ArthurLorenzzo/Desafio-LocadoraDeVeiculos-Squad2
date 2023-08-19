package com.squad2.Locadoraveiculos.controllers;

import com.squad2.Locadoraveiculos.dtos.carroDto.CriarCarroDto;
import com.squad2.Locadoraveiculos.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/api/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<?> cadastrarCarro (@RequestBody CriarCarroDto carroDTO){
        try{
            var carroCriado = carroService.criarCarro(carroDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(carroCriado);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> retornarCarros (){
        try{
            var listaDeCarros = carroService.retornarTodosOsCarros();
            return ResponseEntity.status(HttpStatus.OK).body(listaDeCarros);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> retornarCarroPorId (@PathVariable(value = "id") Long id){
        try{
            var carroRetornado = carroService.retornarCarroPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(carroRetornado);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletarCarroPorId (@PathVariable(value = "id") Long id){
        try{
            carroService.deletarCarro(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
