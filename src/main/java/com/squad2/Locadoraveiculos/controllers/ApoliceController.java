package com.squad2.Locadoraveiculos.controllers;

import com.squad2.Locadoraveiculos.dtos.aluguelDto.CriarAluguelDto;
import com.squad2.Locadoraveiculos.dtos.apoliceDto.CriarApoliceDto;
import com.squad2.Locadoraveiculos.services.AluguelService;
import com.squad2.Locadoraveiculos.services.ApoliceSeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/apolices")
public class ApoliceController {


    @Autowired
    private ApoliceSeguroService apoliceSeguroService;

    @PostMapping
    public ResponseEntity<?> cadastrarApolice (@RequestBody CriarApoliceDto apoliceDto) {

        try{
            var apoliceCriada = apoliceSeguroService.criarApolice(apoliceDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(apoliceCriada);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<?> buscarApoliceById (@PathVariable Long id) {
        try{
            var apolice = apoliceSeguroService.retornarApolicesById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(apolice);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<?> buscarTodosAlugueis () {
        try{
            var apolice = apoliceSeguroService.retornarTodasApolices();
            return ResponseEntity.status(HttpStatus.CREATED).body(apolice);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

}
