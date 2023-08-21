package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dtos.FuncionarioDto;
import com.squad2.Locadoraveiculos.dtos.MotoristaDto;
import com.squad2.Locadoraveiculos.exceptions.ResourceNotFoundException;
import com.squad2.Locadoraveiculos.models.Funcionario;
import com.squad2.Locadoraveiculos.models.Motorista;
import com.squad2.Locadoraveiculos.repositories.FuncionarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private Logger logger = Logger.getLogger(MotoristaService.class.getName());

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioDto cadastrarFuncionario(FuncionarioDto funcionarioDto) {

        logger.info("Cadastrando Funcionário");

        var funcionario = new Funcionario();
        BeanUtils.copyProperties(funcionarioDto,funcionario);
        funcionario = funcionarioRepository.save(funcionario);
        BeanUtils.copyProperties(funcionario,funcionarioDto);
        return funcionarioDto;
    }
    public FuncionarioDto findById(Long id) {

        logger.info("Procurando um funcionário");

        Funcionario funcionario = funcionarioRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        FuncionarioDto FuncionarioDto = new FuncionarioDto();
        BeanUtils.copyProperties(funcionario, FuncionarioDto);

        return FuncionarioDto;
    }
    public void delete(Long id) {

        logger.info("Deletando funcionário");

        var entity = funcionarioRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        funcionarioRepository.delete(entity);
    }

    public List<FuncionarioDto> findAll() {

        logger.info("Procurando todos os funcionários");

        List<Funcionario> listaFuncionario = funcionarioRepository.findAll();
        return listaFuncionario.stream()
                .map(funcionario -> {
                    FuncionarioDto funcionarioDto = new FuncionarioDto();
                    BeanUtils.copyProperties(funcionario, funcionarioDto);
                    return funcionarioDto;
                })
                .collect(Collectors.toList());
    }
}
