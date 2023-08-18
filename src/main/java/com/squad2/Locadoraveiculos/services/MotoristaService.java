package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dto.CriarMotoristaDto;
import com.squad2.Locadoraveiculos.dto.LerMotoristaDto;
import com.squad2.Locadoraveiculos.exceptions.ResourceNotFoundException;
import com.squad2.Locadoraveiculos.models.Motorista;
import com.squad2.Locadoraveiculos.repositories.MotoristaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    public ResponseEntity<LerMotoristaDto> buscarMotoristaPorId(long id) {
        try {
            Motorista motorista = repository.findById(id).
                    orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));

            LerMotoristaDto lerMotoristaDto = new LerMotoristaDto(motorista.getNome(),
                    motorista.getDataDeNascimento(),
                    motorista.getCpf(),
                    motorista.getEmail(),
                    motorista.getSexo(),
                    motorista.getNumeroCNH());

            return ResponseEntity.ok(lerMotoristaDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<LerMotoristaDto>> listarMotoristas() {
        List<Motorista> listaMotorista = repository.findAll();
        List<LerMotoristaDto> listaMotoristaDto = new ArrayList<>();

        for (Motorista motorista : listaMotorista) {
            LerMotoristaDto lerMotoristaDto = new LerMotoristaDto(motorista.getNome(),
                    motorista.getDataDeNascimento(),
                    motorista.getCpf(),
                    motorista.getEmail(),
                    motorista.getSexo(),
                    motorista.getNumeroCNH());
            listaMotoristaDto.add(lerMotoristaDto);
        }

        return ResponseEntity.status(HttpStatus.OK).body(listaMotoristaDto);
    }

    public ResponseEntity<Motorista> atualizarMotorista(Long id, CriarMotoristaDto motoristaDto) {
        Motorista motorista = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));

        BeanUtils.copyProperties(motoristaDto, motorista);
        Motorista motoristaAtualizado = repository.save(motorista);
        return ResponseEntity.ok(motoristaAtualizado);
    }

    public ResponseEntity<?> delete(Long id) {
        try {
            var entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
            repository.delete(entity);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
