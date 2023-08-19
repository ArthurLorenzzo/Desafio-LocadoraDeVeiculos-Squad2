package com.squad2.Locadoraveiculos.controller;

import com.squad2.Locadoraveiculos.dto.CriarAluguelDto;
import com.squad2.Locadoraveiculos.dto.LerCarroDto;
import com.squad2.Locadoraveiculos.models.Aluguel;
import com.squad2.Locadoraveiculos.models.Carro;
import com.squad2.Locadoraveiculos.services.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/alugueis")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @PostMapping
    public ResponseEntity<?> cadastrarAluguel (@RequestBody CriarAluguelDto aluguelDto) {

        try{
            var alugelCriado = aluguelService.criarAluguel(aluguelDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(alugelCriado);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<?> buscarAluguelById (@PathVariable Long id) {
        try{
            var aluguel = aluguelService.retornarAlugueisById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(aluguel);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<?> buscarTodosAlugueis () {
        try{
            var aluguel = aluguelService.retornarTodosAlugueis();
            return ResponseEntity.status(HttpStatus.CREATED).body(aluguel);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

}
