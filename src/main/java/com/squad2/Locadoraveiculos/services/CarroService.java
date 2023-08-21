package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dtos.carroDtos.CarroDto;
import com.squad2.Locadoraveiculos.dtos.carroDtos.LerCarroDto;
import com.squad2.Locadoraveiculos.exceptions.RequiredObjectIsNullException;
import com.squad2.Locadoraveiculos.exceptions.ResourceNotFoundException;
import com.squad2.Locadoraveiculos.models.Acessorio;
import com.squad2.Locadoraveiculos.models.Carro;
import com.squad2.Locadoraveiculos.models.ModeloCarro;
import com.squad2.Locadoraveiculos.repositories.AcessorioRepository;
import com.squad2.Locadoraveiculos.repositories.CarroRepository;
import com.squad2.Locadoraveiculos.repositories.ModeloCarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private AcessorioRepository acessorioRepository;

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;


    public LerCarroDto criarCarro(CarroDto carroDTO) {
        if (carroDTO == null){throw new RequiredObjectIsNullException();}
        var carroCriado = new Carro();
        BeanUtils.copyProperties(carroDTO,carroCriado, "modeloCarro_id", "acessorios_id");
        List<Acessorio> listaAcessorio = carroDTO
                .getAcessorios_id()
                .stream()
                .map(idAcessorio -> {
                    var acessorio = acessorioRepository.findById(idAcessorio)
                            .orElseThrow(ResourceNotFoundException::new);
                    return acessorio;
        }).toList();
        carroCriado.setAcessorios(listaAcessorio);

        carroCriado.setModeloCarro(modeloCarroRepository.findById(carroDTO.getModeloCarro_id())
                .orElseThrow(ResourceNotFoundException::new));

        LerCarroDto lerCarroDto = new LerCarroDto();
        carroCriado = carroRepository.save(carroCriado);
        BeanUtils.copyProperties(carroCriado,lerCarroDto);
        return lerCarroDto;
    }

    public List<LerCarroDto> retornarTodosOsCarros(){
        var carrosRecuperadosDoBanco = carroRepository.findAll();
        var listaDeRetornoDto = carrosRecuperadosDoBanco
                .stream()
                .map(carro -> {
                    var carroDto = new LerCarroDto();
                    BeanUtils.copyProperties(carro,carroDto);
                    return carroDto;
                }).collect(Collectors.toList());
        return listaDeRetornoDto;
    }

    public LerCarroDto retornarCarroPorId(long id){
        var carroRecuperadoDoBanco = retornarCarroDoBancoPorId(id);
        var carroDto = new LerCarroDto();
        BeanUtils.copyProperties(carroRecuperadoDoBanco, carroDto);
        return carroDto;
    }
    public void deletarCarro(long id){
        var carroRecuperadoDoBanco = retornarCarroDoBancoPorId(id);
        carroRepository.delete(carroRecuperadoDoBanco);
    }
    private Carro retornarCarroDoBancoPorId(long id){
        return carroRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
