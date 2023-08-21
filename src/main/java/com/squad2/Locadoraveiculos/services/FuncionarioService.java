package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dtos.FuncionarioDto;
import com.squad2.Locadoraveiculos.models.Funcionario;
import com.squad2.Locadoraveiculos.repositories.FuncionarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioService {

    private FuncionarioRepository repository;

    public Funcionario criarFuncionario(FuncionarioDto funcionarioDto) {
        var funcionario = new Funcionario();

        BeanUtils.copyProperties(funcionarioDto, funcionario);
        Funcionario funcionarioCriado = repository.save(funcionario);
        return funcionarioCriado;
    }

    public Funcionario atualizarFuncionario(Long id, FuncionarioDto funcionarioDto) {
        Funcionario funcionario = repository.findById(id).orElseThrow();

        BeanUtils.copyProperties(funcionarioDto, funcionario);
        Funcionario funcionarioAtualizado = repository.save(funcionario);
        return funcionarioAtualizado;
    }

    public void delete(Long id) {

    }
    public List<FuncionarioDto> listarFuncionarios() {
        List<Funcionario> listaFuncionario = repository.findAll();
        var listaDeFuncionarioDto = new ArrayList<FuncionarioDto>();
        var lerFuncionarioDto = new FuncionarioDto();
       listaFuncionario.forEach(funcionario -> {
           BeanUtils.copyProperties(funcionario, lerFuncionarioDto);
            listaDeFuncionarioDto.add(lerFuncionarioDto);
        });
        return listaDeFuncionarioDto;
    }


}
