package com.squad2.Locadoraveiculos.controller;

import com.squad2.Locadoraveiculos.dto.CriarMotoristaDto;
import com.squad2.Locadoraveiculos.models.Motorista;
import com.squad2.Locadoraveiculos.repositories.MotoristaRepository;
import com.squad2.Locadoraveiculos.services.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaService service;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @GetMapping(
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> getAll() {
        return service.listarMotoristas();
    }

    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> getPessoaById (@PathVariable(value = "id")Long id) {
        return service.buscarMotoristaPorId(id);
    }

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Motorista> salvar(@RequestBody CriarMotoristaDto motoristaDto) {
        return service.criarMotorista(motoristaDto);
    }

    @PutMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Motorista> atualizar(@PathVariable Long id, @RequestBody CriarMotoristaDto motorista) {
        return service.atualizarMotorista(id, motorista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        return service.delete(id);
    }
}
