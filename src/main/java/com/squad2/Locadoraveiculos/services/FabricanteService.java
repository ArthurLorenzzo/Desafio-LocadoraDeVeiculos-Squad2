package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dtos.fabricantesDto.FabricanteDto;
import com.squad2.Locadoraveiculos.models.Fabricante;
import com.squad2.Locadoraveiculos.repositories.FabricanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    public FabricanteDto criarFabricante(FabricanteDto fabricanteDto) {
            var fabricante = new Fabricante();
            BeanUtils.copyProperties(fabricanteDto, fabricante);
            var fabricanteCriado = fabricanteRepository.save(fabricante);
            BeanUtils.copyProperties(fabricanteCriado,fabricanteDto);
            return fabricanteDto;

    }
    public List<FabricanteDto> retornar() {
        var fabricantesRetornados = fabricanteRepository.findAll();
        var fabricanteDtos = fabricantesRetornados
                .stream()
                .map(fabricante -> {
                    var fabricanteDto = new FabricanteDto();
                    BeanUtils.copyProperties(fabricante, fabricanteDto);
                    return fabricanteDto;
                })
                .toList();
        return fabricanteDtos;
    }

    public void deletarPorId(Long id) {
        var fabricante = retornarFabricanteDoBancoPorId(id);
        fabricanteRepository.delete(fabricante);

    }
    public FabricanteDto retornarPorId(Long id) {
        var fabricante = retornarFabricanteDoBancoPorId(id);
        var fabricanteDto = new FabricanteDto();
        BeanUtils.copyProperties(fabricante,fabricanteDto);
        return fabricanteDto;

    }
    private Fabricante retornarFabricanteDoBancoPorId(Long id) {
        return fabricanteRepository.findById(id).orElseThrow();

    }
}
