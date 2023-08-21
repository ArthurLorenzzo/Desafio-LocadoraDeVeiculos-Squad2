package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dtos.FuncionarioDto;
import com.squad2.Locadoraveiculos.models.Funcionario;
import com.squad2.Locadoraveiculos.repositories.FuncionarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioDto cadastrarFuncionario(FuncionarioDto funcionarioDto) {
        var funcionario = new Funcionario();
        BeanUtils.copyProperties(funcionarioDto,funcionario);
        funcionario = funcionarioRepository.save(funcionario);
        BeanUtils.copyProperties(funcionario,funcionarioDto);
        return funcionarioDto;
    }







}
