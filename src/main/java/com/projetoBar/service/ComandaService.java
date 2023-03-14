package com.projetoBar.service;

import com.projetoBar.enums.StatusEnum;
import com.projetoBar.model.ComandaModel;
import com.projetoBar.model.ProdutosNaComandaModel;
import com.projetoBar.model.dto.ExibirTudoNaComandaDTO;
import com.projetoBar.model.dto.ProdutosNaComandaDTO;
import com.projetoBar.repository.ComandaRepository;
import com.projetoBar.repository.ProdutoRepository;
import com.projetoBar.repository.ProdutosNaComandaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        novaComanda.setDataCriacao(Timestamp.valueOf(LocalDateTime.now()));
        novaComanda.setStatus(StatusEnum.ABERTO.toString());

        comandaRepository.save(novaComanda);

        return novaComanda;

    }

    public ExibirTudoNaComandaDTO fechamentoDeComanda(Integer id){

        ComandaModel comanda = comandaRepository.selecionarPeloNumero(id);

        Double valorTotal = produtosNaComandaService.totalDeValor(id);

        comanda.setValorTotal(valorTotal);

        comanda.setStatus(StatusEnum.FECHADO.toString());

        List<ProdutosNaComandaDTO> listaDeProdutos = produtosNaComandaService.listaDeProdutosNaComanda(id);

        comandaRepository.save(comanda);

        ExibirTudoNaComandaDTO exibirDto = new ExibirTudoNaComandaDTO(id, valorTotal, listaDeProdutos);

        return exibirDto;
    }

    public List<ComandaModel> comandasAbertas(){

       List<ComandaModel> comandasAbertas = comandaRepository.listaDeComandasAbertas();

       return comandasAbertas;

    }


}
