package com.squad2.Locadoraveiculos.services;
import com.squad2.Locadoraveiculos.dtos.AcessorioDto;
import com.squad2.Locadoraveiculos.exceptions.ResourceNotFoundException;
import com.squad2.Locadoraveiculos.models.Acessorio;
import com.squad2.Locadoraveiculos.repositories.AcessorioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcessorioService {

    @Autowired
    private AcessorioRepository acessorioRepository;

    public AcessorioDto criarAcessorio(AcessorioDto acessorioDto) {
        var acessorio = new Acessorio();
        BeanUtils.copyProperties(acessorioDto, acessorio);
        var acessorioCriado = acessorioRepository.save(acessorio);
        BeanUtils.copyProperties(acessorioCriado,acessorioDto);
        return acessorioDto;
    }

    public List<AcessorioDto> retornarTodos() {
        var acessoriosRetornados = acessorioRepository.findAll();
        var acessoriosDtos = acessoriosRetornados
                .stream()
                .map(acessorio ->{
                    var acessorioDto = new AcessorioDto();
                    BeanUtils.copyProperties(acessorio,acessorioDto);
                    return acessorioDto;})
                .toList();
        return acessoriosDtos;
    }

    public void deletarPorId(Long id) {
        var acessorio = recuperarAcessorioDoBanco(id);
        acessorioRepository.delete(acessorio);
    }


    public AcessorioDto retornaPorId(Long id) {
            var acessorio = recuperarAcessorioDoBanco(id);
            var acessorioDto = new AcessorioDto();
            BeanUtils.copyProperties(acessorio,acessorioDto);
            return acessorioDto;
    }

    private Acessorio recuperarAcessorioDoBanco(Long id){
        return acessorioRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
