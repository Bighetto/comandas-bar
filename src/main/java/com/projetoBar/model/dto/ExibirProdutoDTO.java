package com.projetoBar.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projetoBar.enums.TipoProdutoEnum;
import com.projetoBar.model.ProdutoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExibirProdutoDTO {


    @JsonProperty(value = "nome")
    private String nome;


    @JsonProperty(value = "valorDeVenda")
    private Double valorDeVenda;

    @JsonProperty("tipo")
    private TipoProdutoEnum tipo;

    public ExibirProdutoDTO(ProdutoModel produtoModel){

        this.nome = produtoModel.getNome();
        this.valorDeVenda = produtoModel.getValorDeVenda();
        this.tipo = produtoModel.getTipo();

    }
}
