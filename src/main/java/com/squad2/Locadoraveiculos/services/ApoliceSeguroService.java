package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dtos.apoliceDto.CriarApoliceDto;
import com.squad2.Locadoraveiculos.models.Aluguel;
import com.squad2.Locadoraveiculos.models.ApoliceSeguro;
import com.squad2.Locadoraveiculos.repositories.ApoliceSeguroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApoliceSeguroService {
    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    @Transactional
    public ApoliceSeguro criarApolice (CriarApoliceDto apoliceDto) {


        ApoliceSeguro apoliceSeguro = new ApoliceSeguro();
        apoliceSeguro.setValorFranquia(apoliceDto.getValorFranquia());
        apoliceSeguro.setProtecaoRoubo(apoliceDto.isProtecaoRoubo());
        apoliceSeguro.setProtecaoTerceiro(apoliceDto.isProtecaoTerceiro());
        apoliceSeguro.setProtecaoCausasNaturais(apoliceDto.isProtecaoCausasNaturais());

        return apoliceSeguroRepository.save(apoliceSeguro);

    }

    public Optional<ApoliceSeguro> retornarApolicesById (Long id) {

        return apoliceSeguroRepository.findById(id);

    }

    public List<ApoliceSeguro> retornarTodasApolices () {

        return apoliceSeguroRepository.findAll();

    }

    public void deletarApolice ( Long id ){
        apoliceSeguroRepository.findById(id)
                .map( apolice -> {
                    apoliceSeguroRepository.delete(apolice );
                    return apolice;
                });
    }

}
