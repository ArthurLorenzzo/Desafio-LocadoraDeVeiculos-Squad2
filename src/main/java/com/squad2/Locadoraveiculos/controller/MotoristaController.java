package com.squad2.Locadoraveiculos.controller;

import com.squad2.Locadoraveiculos.dto.CriarMotoristaDto;
import com.squad2.Locadoraveiculos.models.Motorista;

import com.squad2.Locadoraveiculos.repositories.MotoristaRepository;
import com.squad2.Locadoraveiculos.services.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaService service;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody CriarMotoristaDto motoristaDto) {
        return service.criarMotorista(motoristaDto);
    }

    @GetMapping
    public List<Motorista> getAll ( ) {

        return motoristaRepository.findAll();

    }

    @GetMapping("{id}")
    public Motorista getPessoaById (@PathVariable Long id) {

        return motoristaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("{id}")
    public void deletar (@PathVariable Long id) {
        motoristaRepository.findById(id).map( motorista -> {
                motoristaRepository.delete(motorista);
                return Void.TYPE;})
                    .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Long id, @RequestBody Motorista motorista){
        motoristaRepository.findById(id).map(motorista1 -> {
            motorista.setId(motorista1.getId());
            return motoristaRepository.save(motorista);
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }


}
