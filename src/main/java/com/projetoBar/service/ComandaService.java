package com.projetoBar.service;

import com.projetoBar.enums.StatusEnum;
import com.projetoBar.model.ComandaModel;
import com.projetoBar.repository.ComandaRepository;
import com.projetoBar.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComandaService {

    private final ComandaRepository comandaRepository;
    private final ProdutosNaComandaService produtosNaComandaService;

    public ComandaModel aberturaDeComanda(){

        ComandaModel novaComanda = new ComandaModel();
        novaComanda.setDataCriacao(Timestamp.valueOf(LocalDateTime.now()));
        novaComanda.setStatus(StatusEnum.ABERTO.toString());

        comandaRepository.save(novaComanda);

        return novaComanda;

    }

    public Double fechamentoDeComanda(Integer id){

        ComandaModel comanda = comandaRepository.selecionarPeloNumero(id);

        Double valorTotal = produtosNaComandaService.totalDeValor(id);

        comanda.setValorTotal(valorTotal);

        comanda.setStatus(StatusEnum.FECHADO.toString());


        comandaRepository.save(comanda);

        return valorTotal;
    }

    public List<ComandaModel> comandasAbertas(){

       List<ComandaModel> comandasAbertas = comandaRepository.listaDeComandasAbertas();

       return comandasAbertas;

    }


}
