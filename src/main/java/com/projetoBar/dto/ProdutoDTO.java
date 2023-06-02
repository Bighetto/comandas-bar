package com.projetoBar.model.dto;

import com.projetoBar.model.ProdutoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProdutoDTO {

    private Integer idproduto;

    private String nome;

    private Double valorDeVenda;


    public ProdutoDTO(ProdutoModel produtoModel) {
        this.idproduto = produtoModel.getId();
        this.nome = produtoModel.getNome();
        this.valorDeVenda = produtoModel.getValorDeVenda();
    }
}
