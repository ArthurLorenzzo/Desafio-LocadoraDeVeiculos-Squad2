package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dtos.motoristaDto.MotoristaDto;
import com.squad2.Locadoraveiculos.exceptions.ResourceNotFoundException;
import com.squad2.Locadoraveiculos.models.Motorista;
import com.squad2.Locadoraveiculos.repositories.MotoristaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository repository;

    public MotoristaDto create(MotoristaDto motoristaDto) {

        Motorista motorista = new Motorista();
        BeanUtils.copyProperties(motoristaDto, motorista);

        motorista = repository.save(motorista);

        MotoristaDto motoristaCriado = new MotoristaDto();
        BeanUtils.copyProperties(motorista, motoristaCriado);

        return motoristaCriado;
    }

    public MotoristaDto findById(Long id) {

        Motorista motorista = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));

        MotoristaDto MotoristaDto = new MotoristaDto();
        BeanUtils.copyProperties(motorista, MotoristaDto);

        return MotoristaDto;
    }

    public List<MotoristaDto> findAll() {

        List<Motorista> listaMotorista = repository.findAll();
        return listaMotorista.stream()
                .map(motorista -> {
                    MotoristaDto motoristaDto = new MotoristaDto();
                    BeanUtils.copyProperties(motorista, motoristaDto);
                    return motoristaDto;
                })
                .collect(Collectors.toList());
    }

    public MotoristaDto update(MotoristaDto motoristaDto) {

        var entity = repository.findById(motoristaDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));

        BeanUtils.copyProperties(motoristaDto, entity);

        repository.save(entity);

        return motoristaDto;
    }

    public void delete(Long id) {

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
        repository.delete(entity);
    }
}
