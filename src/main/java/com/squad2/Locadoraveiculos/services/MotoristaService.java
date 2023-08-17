package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dto.CriarMotoristaDto;
import com.squad2.Locadoraveiculos.dto.LerMotoristaDto;
import com.squad2.Locadoraveiculos.models.Motorista;
import com.squad2.Locadoraveiculos.repositories.MotoristaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository repository;

    public ResponseEntity<Motorista> criarMotorista(CriarMotoristaDto motoristaDto) {

        var motorista = new Motorista();
        BeanUtils.copyProperties(motoristaDto, motorista);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(motorista));
    }

    public ResponseEntity<List<LerMotoristaDto>> listarMotoristas() {
        var listaMotorista = repository.findAll();
        var listaMotoristaDto = new ArrayList<LerMotoristaDto>();
        listaMotorista.forEach((x) -> {
            LerMotoristaDto lerMotoristaDto = new LerMotoristaDto(
                    x.getId(), x.getNome(), x.getCpf(), x.getEmail(), x.getSexo(), x.getNumeroCNH()
            );
            listaMotoristaDto.add(lerMotoristaDto);
        });
        return ResponseEntity.status(HttpStatus.OK).body(listaMotoristaDto);
    }
}
