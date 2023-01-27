package com.projetoBar.service;

import com.projetoBar.model.ComandaModel;
import com.projetoBar.model.ProdutoModel;
import com.projetoBar.model.ProdutosNaComandaModel;
import com.projetoBar.repository.ComandaRepository;
import com.projetoBar.repository.ProdutoRepository;
import com.projetoBar.repository.ProdutosNaComandaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutosNaComandaService {

    private final ProdutoRepository produtoRepository;
    private final ComandaRepository comandaRepository;
    private final ProdutosNaComandaRepository produtosNaComandaRepository;



    public void adicionarProduto(Integer idComanda, String nomeProduto, Integer quantidade){

        ProdutoModel produto = produtoRepository.selecionarProdutoPeloNome(nomeProduto);

        ComandaModel comanda = comandaRepository.selecionarPeloNumero(idComanda);


        produtosNaComandaRepository.inserirProdutoNaComanda(idComanda,
                produto.getNome(),
                produto.getValorDeVenda(),
                quantidade);

    }

    public List<ProdutosNaComandaModel> listaDeProdutosNaComanda(Integer id){

        List<ProdutosNaComandaModel>listaDeProdutos = produtosNaComandaRepository.selecionarProdutosNaComanda(id);

        return listaDeProdutos;
    }


    public Double totalDeValor(Integer idComanda) {

        Double valorTotalComanda = produtosNaComandaRepository.selecionarValorTotalComanda(idComanda);

        return valorTotalComanda;
    }
}
