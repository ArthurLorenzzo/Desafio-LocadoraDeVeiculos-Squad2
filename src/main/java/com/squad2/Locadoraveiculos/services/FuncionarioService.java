package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dto.CriarFuncionarioDto;
import com.squad2.Locadoraveiculos.dto.LerFuncionarioDto;
import com.squad2.Locadoraveiculos.models.Funcionario;
import com.squad2.Locadoraveiculos.repositories.FuncionarioRepository;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioService {

    private FuncionarioRepository repository;

    public Funcionario criarFuncionario(CriarFuncionarioDto funcionarioDto) {
        var funcionario = new Funcionario();

        BeanUtils.copyProperties(funcionarioDto, funcionario);
        Funcionario funcionarioCriado = repository.save(funcionario);
        return funcionarioCriado;
    }

    public Funcionario atualizarFuncionario(Long id, CriarFuncionarioDto funcionarioDto) {
        Funcionario funcionario = repository.findById(id).orElseThrow();

        BeanUtils.copyProperties(funcionarioDto, funcionario);
        Funcionario funcionarioAtualizado = repository.save(funcionario);
        return funcionarioAtualizado;
    }

    public void delete(Long id) {

    }
    public List<LerFuncionarioDto> listarFuncionarios() {
        List<Funcionario> listaFuncionario = repository.findAll();
        var listaDeFuncionarioDto = new ArrayList<LerFuncionarioDto>();
        var lerFuncionarioDto = new LerFuncionarioDto();
       listaFuncionario.forEach(funcionario -> {
           BeanUtils.copyProperties(funcionario, lerFuncionarioDto);
            listaDeFuncionarioDto.add(lerFuncionarioDto);
        });
        return listaDeFuncionarioDto;
    }


}
