package com.squad2.Locadoraveiculos.services;
import com.squad2.Locadoraveiculos.dtos.AluguelDto;
import com.squad2.Locadoraveiculos.exceptions.ResourceNotFoundException;
import com.squad2.Locadoraveiculos.models.Aluguel;
import com.squad2.Locadoraveiculos.models.ApoliceSeguro;
import com.squad2.Locadoraveiculos.models.Carro;
import com.squad2.Locadoraveiculos.models.Motorista;
import com.squad2.Locadoraveiculos.repositories.AluguelRepository;
import com.squad2.Locadoraveiculos.repositories.ApoliceSeguroRepository;
import com.squad2.Locadoraveiculos.repositories.CarroRepository;
import com.squad2.Locadoraveiculos.repositories.MotoristaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class AluguelService {
    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;
    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    @Transactional
    public Aluguel criarAluguel(AluguelDto aluguelDTO) {

        Long idMotorista = aluguelDTO.getMotorista();
        Motorista motorista = motoristaRepository
                .findById(idMotorista)
                .orElseThrow(() -> new ResourceNotFoundException("Código de cliente inválido."));

        Long idApolice = aluguelDTO.getApolicesSeguro();
        ApoliceSeguro apoliceSeguro = apoliceSeguroRepository
                .findById(idApolice)
                .orElseThrow(() -> new ResourceNotFoundException("Código de cliente inválido."));


        var listaCarros = new ArrayList<Carro>();
        aluguelDTO.getCarros().forEach(idCarro -> {
            listaCarros.add(carroRepository.findById(idCarro).orElseThrow());
        });

        Aluguel aluguel = new Aluguel();
        aluguel.setDataPedido(LocalDate.now());
        aluguel.setDataEntrega(aluguelDTO.getDataEntrega());
        aluguel.setDataDevolucao(aluguelDTO.getDataDevolucao());
        aluguel.setValorTotal(aluguelDTO.getValorTotal());
        aluguel.setMotorista(motorista);
        aluguel.setApoliceSeguro(apoliceSeguro);
        aluguel.setCarros(listaCarros);

        return aluguelRepository.save(aluguel);

    }

    public Optional<Aluguel> retornarAlugueisById (Long id) {

       return aluguelRepository.findById(id);

    }

    public List<Aluguel> retornarTodosAlugueis () {

        return aluguelRepository.findAll();

    }

    public void deletarAluguel ( Long id ){
        aluguelRepository.findById(id)
                .map( alugel -> {
                    aluguelRepository.delete(alugel );
                    return alugel;
                });
    }

}
