package com.squad2.Locadoraveiculos.services;

import com.squad2.Locadoraveiculos.dto.CriarCarroDTO;
import com.squad2.Locadoraveiculos.dto.LerCarroDto;
import com.squad2.Locadoraveiculos.models.Acessorio;
import com.squad2.Locadoraveiculos.models.Carro;
import com.squad2.Locadoraveiculos.repositories.AcessorioRepository;
import com.squad2.Locadoraveiculos.repositories.CarroRepository;
import com.squad2.Locadoraveiculos.repositories.ModeloCarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private AcessorioRepository acessorioRepository;
    @Autowired
    private ModeloCarroRepository modeloCarroRepository;


    public Carro criarCarro(CriarCarroDTO carroDTO) {


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
        return carroCriado;
    }
}
