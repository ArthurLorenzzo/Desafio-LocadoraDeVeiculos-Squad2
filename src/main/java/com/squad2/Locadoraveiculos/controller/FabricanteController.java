package com.squad2.Locadoraveiculos.controller;

import com.squad2.Locadoraveiculos.dto.CriarFabricanteDto;
import com.squad2.Locadoraveiculos.models.Fabricante;
import com.squad2.Locadoraveiculos.services.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/fabricantes")
public class FabricanteController {
    @Autowired
    private FabricanteService fabricanteService;
    @PostMapping
    public ResponseEntity<Fabricante>  cadastrar (@RequestBody CriarFabricanteDto fabricanteDto){
       return fabricanteService.criarFabricante(fabricanteDto);
    }
    @GetMapping
    public ResponseEntity<List<Fabricante>> retornar () {
       return fabricanteService.retornar();
   }
   @GetMapping("{id}")
    public ResponseEntity <?> retornarPorId (@PathVariable Long id){
       return fabricanteService.retornarPorId(id);
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePorId(@PathVariable Long id){
        return fabricanteService.deletarPorId(id);
   }
}
