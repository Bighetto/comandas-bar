package com.projetoBar.dto;

import com.projetoBar.model.ProdutoModel;
import com.projetoBar.model.ProdutosNaComandaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutosNaComandaDTO {

    private String nomeProduto;

    private Double valorProduto;

    private Integer quantidade;

    public ProdutosNaComandaDTO(ProdutosNaComandaModel produtosNaComandaModel){
        this.nomeProduto = produtosNaComandaModel.getNomeProduto();
        this.valorProduto = produtosNaComandaModel.getValorProduto();
        this.quantidade = produtosNaComandaModel.getQuantidade();

    }

    public ProdutosNaComandaDTO(ProdutoModel produtosNaComandaModel, Integer quantidade){
        this.nomeProduto = produtosNaComandaModel.getNome();
        this.valorProduto = produtosNaComandaModel.getValorDeVenda();
        this.quantidade = quantidade;

    }
}
