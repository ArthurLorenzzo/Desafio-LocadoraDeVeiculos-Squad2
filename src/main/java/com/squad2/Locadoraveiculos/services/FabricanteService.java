package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dtos.fabricanteDto.CriarFabricanteDto;
import com.squad2.Locadoraveiculos.models.Fabricante;
import com.squad2.Locadoraveiculos.repositories.FabricanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    public ResponseEntity<Fabricante> criarFabricante(CriarFabricanteDto fabricanteDto) {
        try {
            var fabricante = new Fabricante();
            BeanUtils.copyProperties(fabricanteDto, fabricante);
            var fabricanteCriado = fabricanteRepository.save(fabricante);
            return ResponseEntity.status(HttpStatus.CREATED).body(fabricanteCriado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity<List<Fabricante>> retornar() {
        try {
            var fabricantesRetornados = fabricanteRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(fabricantesRetornados);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<?> retornarPorId(Long id) {
        try{
            var fabricante = retornarFabricanteDoBancoPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(fabricante);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public ResponseEntity<?> deletarPorId(Long id) {
        try{
            var fabricante = retornarFabricanteDoBancoPorId(id);
            fabricanteRepository.delete(fabricante);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private Fabricante retornarFabricanteDoBancoPorId(Long id) {
        return fabricanteRepository.findById(id).orElseThrow();

    }
}
