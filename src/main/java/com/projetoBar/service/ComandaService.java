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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ComandaService {

    private final ComandaRepository comandaRepository;
    private final ProdutosNaComandaService produtosNaComandaService;
    private final ProdutosNaComandaRepository produtosNaComandaRepository;

    public ComandaModel aberturaDeComanda(Integer id){

        ComandaModel novaComanda = new ComandaModel();
        novaComanda.setDataCriacao(LocalDate.now());
        novaComanda.setId(id);
        novaComanda.setValorTotal(0.00);
        novaComanda.setStatus(StatusEnum.ABERTO.toString());

        comandaRepository.abrirComanda(id,
                LocalDate.now(),
                StatusEnum.ABERTO.toString());

        return novaComanda;

    }

//    private Integer validarMontanteDiario(LocalDate data) { //TODO: IMPLEMENTACAO FUTURA DE SELECIONAR COMANDA NO DIA PARA EXIBIR EM UM DASH
//
//        List<ComandaModel> lista = comandaRepository.selecionarTodasAsComandasDoDia(data);
//
//
//    }

    public ExibirTudoNaComandaDTO fechamentoDeComanda(Integer id){

        Double valorTotal = produtosNaComandaService.totalDeValor(id);

        if (valorTotal == null){
            valorTotal = 0.0;
        }

        List<ProdutosNaComandaDTO> listaDeProdutos = produtosNaComandaService.listaDeProdutosNaComanda(id);

        comandaRepository.atualizarComandaAberta(valorTotal, id);

        produtosNaComandaRepository.atualizarFechamentoDeComanda(id);

        ExibirTudoNaComandaDTO exibirDto = new ExibirTudoNaComandaDTO(id, valorTotal, listaDeProdutos);

        return exibirDto;
    }

    public ExibirTudoNaComandaDTO exibirFechamentoDeComanda(Integer id){


        Double valorTotal = produtosNaComandaService.totalDeValor(id);

        List<ProdutosNaComandaDTO> listaDeProdutos = produtosNaComandaService.listaDeProdutosNaComanda(id);


        ExibirTudoNaComandaDTO exibirDto = new ExibirTudoNaComandaDTO(id, valorTotal, listaDeProdutos);

        return exibirDto;
    }

    public List<ComandaModel> comandasAbertas(){

       List<ComandaModel> comandasAbertas = comandaRepository.listaDeComandasAbertas();

       return comandasAbertas;

    }


}
