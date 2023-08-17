package com.squad2.Locadoraveiculos.services;
import com.squad2.Locadoraveiculos.dto.CriarAcessorioDto;
import com.squad2.Locadoraveiculos.models.Acessorio;
import com.squad2.Locadoraveiculos.repositories.AcessorioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AcessorioService {

    @Autowired
    private AcessorioRepository acessorioRepository;

    public ResponseEntity<Acessorio> criarAcessorio(CriarAcessorioDto acessorioDto) {
        try {
            var acessorio = new Acessorio();
            BeanUtils.copyProperties(acessorioDto, acessorio);
            var acessorioCriado = acessorioRepository.save(acessorio);
            return ResponseEntity.status(HttpStatus.CREATED).body(acessorioCriado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity<List<Acessorio>> retornarTodos() {
        try {
            var acessoriosRetornados = acessorioRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(acessoriosRetornados);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity<?> deletarPorId(Long id) {
        try{
            var acessorio = retornarAcessorioDoBancoPorId(id);
            acessorioRepository.delete(acessorio);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    private Acessorio retornarAcessorioDoBancoPorId(Long id){
        return acessorioRepository.findById(id).orElseThrow();
    }

    public ResponseEntity<?> retornaPorId(Long id) {
        try{
            var acessorio = retornarAcessorioDoBancoPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(acessorio);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
