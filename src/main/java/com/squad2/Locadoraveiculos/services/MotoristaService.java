package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dtos.motoristaDto.MotoristaDto;
import com.squad2.Locadoraveiculos.exceptions.DuplicateEmailException;
import com.squad2.Locadoraveiculos.exceptions.RequiredObjectIsNullException;
import com.squad2.Locadoraveiculos.exceptions.ResourceNotFoundException;
import com.squad2.Locadoraveiculos.models.Motorista;
import com.squad2.Locadoraveiculos.repositories.MotoristaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class MotoristaService {

    private Logger logger = Logger.getLogger(MotoristaService.class.getName());

    @Autowired
    private MotoristaRepository repository;

    public MotoristaDto create(MotoristaDto motoristaDto) {

        if (motoristaDto == null) throw new RequiredObjectIsNullException();

        logger.info("Creating one driver!");

        if (emailExists(motoristaDto.getEmail()))
            throw new DuplicateEmailException("Erro! Email já registrado.");

        Motorista motorista = new Motorista();
        BeanUtils.copyProperties(motoristaDto, motorista);

        motorista = repository.save(motorista);

        MotoristaDto motoristaCriado = new MotoristaDto();
        BeanUtils.copyProperties(motorista, motoristaCriado);

        return motoristaCriado;
    }

    public MotoristaDto findById(Long id) {

        logger.info("Finding one driver!");

        Motorista motorista = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));

        MotoristaDto MotoristaDto = new MotoristaDto();
        BeanUtils.copyProperties(motorista, MotoristaDto);

        return MotoristaDto;
    }

    public List<MotoristaDto> findAll() {

        logger.info("Finding all drivers!");

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

        if (motoristaDto == null) throw new RequiredObjectIsNullException();

        logger.info("Updating one driver!");

        var entity = repository.findById(motoristaDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));

        if (!entity.getEmail().equals(motoristaDto.getEmail()) && emailExists(motoristaDto.getEmail()))
            throw new DuplicateEmailException("Erro! Email já registrado.");

        BeanUtils.copyProperties(motoristaDto, entity);

        repository.save(entity);

        return motoristaDto;
    }

    public void delete(Long id) {

        logger.info("Deleting one driver!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
        repository.delete(entity);
    }

    private boolean emailExists(String email) {
        Long count = repository.countByEmail(email);
        return count > 0;
    }
}
