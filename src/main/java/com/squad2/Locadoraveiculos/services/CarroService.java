package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dto.CriarCarroDTO;
import com.squad2.Locadoraveiculos.dto.LerCarroDto;
import com.squad2.Locadoraveiculos.models.Acessorio;
import com.squad2.Locadoraveiculos.models.Carro;
import com.squad2.Locadoraveiculos.repositories.AcessorioRepository;
import com.squad2.Locadoraveiculos.repositories.CarroRepository;
import com.squad2.Locadoraveiculos.repositories.ModeloCarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private AcessorioRepository acessorioRepository;
    @Autowired
    private ModeloCarroRepository modeloCarroRepository;


    public LerCarroDto criarCarro(CriarCarroDTO carroDTO) {


        var carroCriado = new Carro();
        carroCriado.setPlaca(carroDTO.getPlaca());
        carroCriado.setChassi(carroDTO.getChassi());
        carroCriado.setCor(carroDTO.getCor());
        carroCriado.setValorDiaria(carroDTO.getValorDiaria());

        var listaDeAcessorios = new ArrayList<Acessorio>();
        carroDTO.getListaDeAcessoriosId().forEach(idAcessorio -> {
            listaDeAcessorios.add(acessorioRepository.findById(idAcessorio).orElseThrow());
        });
        carroCriado.setAcessorios(listaDeAcessorios);
        var modeloCarro = modeloCarroRepository.findById(carroDTO.getModeloCarroId()).orElseThrow();
        carroCriado.setModeloCarro(modeloCarro);
        carroCriado = carroRepository.save(carroCriado);
        var carroDto = new LerCarroDto();
        BeanUtils.copyProperties(carroCriado,carroDto);
        return carroDto;
    }

    public List<LerCarroDto> retornarTodosOsCarros(){
        var carrosRecuperadosDoBanco = carroRepository.findAll();
        var listaDeRetornoDto = new ArrayList<LerCarroDto>();
        var lercarroDto = new LerCarroDto();
        carrosRecuperadosDoBanco.forEach(carro -> {
            BeanUtils.copyProperties(carro,lercarroDto);
            listaDeRetornoDto.add(lercarroDto);
        });
        return listaDeRetornoDto;
    }

    public LerCarroDto retornarCarroPorId(long id){

        var carroRecuperadoDoBanco = retornarCarroDoBancoPorId(id);
        var lerCarroDto = new LerCarroDto();
        BeanUtils.copyProperties(carroRecuperadoDoBanco,lerCarroDto);
        return lerCarroDto;
    }
    public void deletarCarro(long id){
        var carroRecuperadoDoBanco = retornarCarroDoBancoPorId(id);
        carroRepository.delete(carroRecuperadoDoBanco);
    }
    private Carro retornarCarroDoBancoPorId(long id){
        return carroRepository.findById(id).orElseThrow();
    }
}
