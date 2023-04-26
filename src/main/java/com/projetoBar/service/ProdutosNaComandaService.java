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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutosNaComandaService {

    private final ProdutoRepository produtoRepository;
    private final ComandaRepository comandaRepository;
    private final ProdutosNaComandaRepository produtosNaComandaRepository;



    public ProdutosNaComandaDTO adicionarProduto(Integer idComanda, Integer quantidade, Integer idProduto){

        ProdutoModel produto = produtoRepository.selecionarProdutoPeloId(idProduto);

        ComandaModel comanda = comandaRepository.selecionarPeloNumeroEStatus(idComanda);

        validarQuantidade(produto, quantidade, comanda);

        ProdutosNaComandaDTO produtoDTO = new ProdutosNaComandaDTO(produto, quantidade);

        return produtoDTO;

    }


    public List<ProdutosNaComandaDTO> listaDeProdutosNaComanda(Integer id){

        List<ProdutosNaComandaModel>listaDeProdutos = produtosNaComandaRepository.selecionarProdutosNaComanda(id);

        List<ProdutosNaComandaDTO> listaDto = new ArrayList<>();

        listaDeProdutos.forEach(produto -> listaDto.add(new ProdutosNaComandaDTO(produto)));

        return listaDto;
    }

    public void validarQuantidade(ProdutoModel produto, Integer quantidade, ComandaModel comanda){

        ProdutosNaComandaModel produtoNaComanda = produtosNaComandaRepository.selecionarSeJaExiste(produto.getNome(), comanda.getDataCriacao(), comanda.getId());

        if (produtoNaComanda != null) {

            Integer quantidadeReal = produtoNaComanda.getQuantidade() + quantidade;

            produtosNaComandaRepository.atualizarValorQuantidade(quantidadeReal,
                    comanda.getId(),
                    produto.getNome(),
                    comanda.getDataCriacao());

        }else {
            produtosNaComandaRepository.inserirProdutoNaComanda(comanda.getId(),
                    produto.getNome(),
                    produto.getValorDeVenda(),
                    quantidade,
                    comanda.getDataCriacao());
        }


    }




    public Double totalDeValor(Integer idComanda) {

        Double valorTotalComanda = produtosNaComandaRepository.selecionarValorTotalComanda(idComanda);

        return valorTotalComanda;
    }

    public void deletarProdutoNaComanda(Integer idComanda, Integer idProduto) {

         Optional<ProdutoModel> produto = produtoRepository.findById(idProduto);

         if (produto.get() == null){

             throw new UsernameNotFoundException("Produto nao encontrado");

         }

         produtosNaComandaRepository.deletarProdutoNaComanda(idComanda, produto.get().getNome());


    }
}
