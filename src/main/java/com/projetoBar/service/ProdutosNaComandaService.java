package com.projetoBar.service;

import com.projetoBar.model.ComandaModel;
import com.projetoBar.model.ProdutoModel;
import com.projetoBar.repository.ComandaRepository;
import com.projetoBar.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutosNaComandaService {

    private final ProdutoRepository produtoRepository;
    private final ComandaRepository comandaRepository;



    public void adicionarProduto(Integer idComanda, Integer idProduto, Integer quantidade){

        ProdutoModel produto = produtoRepository.selecionarProdutoPeloId(idProduto);

        ComandaModel comanda = comandaRepository.selecionarPeloNumero(idComanda);

//        Integer idProduto = produto.selecionarIdProduto();

        comandaRepository.inserirProdutoNaComanda(produto.getId(),
                comanda.getDataCriacao(),
                produto.getNome(),
                produto.getValorDeVenda(),
                quantidade,
                comanda.getStatus());

    }

    public List<ProdutoModel> listaDeProdutosNaComanda(Integer id){

        List<ProdutoModel>listaDeProdutos = comandaRepository.selecionarProdutosNaComanda(id);

        return listaDeProdutos;
    }


}
