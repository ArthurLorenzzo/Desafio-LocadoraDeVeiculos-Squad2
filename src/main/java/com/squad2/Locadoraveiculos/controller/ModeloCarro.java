package com.squad2.Locadoraveiculos.controller;

import com.squad2.Locadoraveiculos.dto.CriarAcessorioDto;
import com.squad2.Locadoraveiculos.models.Acessorio;
import com.squad2.Locadoraveiculos.services.AcessorioService;
import com.squad2.Locadoraveiculos.services.ModeloCarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ModeloCarro {
    @Autowired
    private ModeloCarroService modeloCarroService;

    /*@PostMapping
    public ResponseEntity<Acessorio> criar (@RequestBody CriarAcessorioDto acessorioDto) { return acessorioService.criarAcessorio(acessorioDto); }*/

    /*@GetMapping
    public ResponseEntity<List<Acessorio>> retornarTodos () { return acessorioService.retornarTodos(); }*/


    /*@GetMapping("{id}")
    public ResponseEntity<?>  retornarPorId (@PathVariable Long id) { return acessorioService.retornaPorId(id); }*/

    /*@DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPorId (@PathVariable Long id) { return acessorioService.deletarPorId(id); }
*/
}

