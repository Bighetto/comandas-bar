package com.projetoBar.service;

import com.projetoBar.model.ComandaModel;
import com.projetoBar.model.ProdutoModel;
import com.projetoBar.model.ProdutosNaComandaModel;
import com.projetoBar.model.dto.ExibirProdutoDTO;
import com.projetoBar.model.dto.ProdutosNaComandaDTO;
import com.projetoBar.repository.ComandaRepository;
import com.projetoBar.repository.ProdutoRepository;
import com.projetoBar.repository.ProdutosNaComandaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProdutosNaComandaService {

    private final ProdutoRepository produtoRepository;
    private final ComandaRepository comandaRepository;
    private final ProdutosNaComandaRepository produtosNaComandaRepository;



    public ProdutosNaComandaDTO adicionarProduto(Integer idComanda, Integer quantidade, Integer idProduto){

        ProdutoModel produto = produtoRepository.selecionarProdutoPeloId(idProduto);

        ComandaModel comanda = comandaRepository.selecionarPeloNumero(idComanda);


        produtosNaComandaRepository.inserirProdutoNaComanda(idComanda,
                produto.getNome(),
                produto.getValorDeVenda(),
                quantidade,
                comanda.getDataCriacao());

        ProdutosNaComandaDTO produtoDTO = new ProdutosNaComandaDTO(produto, quantidade);

        return produtoDTO;

    }

    public List<ProdutosNaComandaDTO> listaDeProdutosNaComanda(Integer id){

        List<ProdutosNaComandaModel>listaDeProdutos = produtosNaComandaRepository.selecionarProdutosNaComanda(id);

        List<ProdutosNaComandaDTO> listaDto = new ArrayList<>();

        listaDeProdutos.forEach(produto -> listaDto.add(new ProdutosNaComandaDTO(produto)));

        return listaDto;
    }


    public Double totalDeValor(Integer idComanda) {

        Double valorTotalComanda = produtosNaComandaRepository.selecionarValorTotalComanda(idComanda);

        return valorTotalComanda;
    }
}
