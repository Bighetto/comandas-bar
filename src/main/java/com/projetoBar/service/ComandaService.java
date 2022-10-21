package com.projetoBar.service;

import com.projetoBar.enums.StatusEnum;
import com.projetoBar.model.ComandaModel;
import com.projetoBar.repository.ComandaRepository;
import com.projetoBar.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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

    public void fechamentoDeComanda(Integer id){

        ComandaModel comanda = comandaRepository.selecionarPeloNumero(id);

        Double valorTotal = produtosNaComandaService.totalDeValor(id);

        comanda.setStatus(StatusEnum.FECHADO.toString());


        comandaRepository.save(comanda);
    }

    public Double totalDeValor(Integer idComanda){

        ComandaModel comanda = comandaRepository.selecionarPeloNumero(idComanda);

        return comanda.getValorTotal();

    }


}
