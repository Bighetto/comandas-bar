package com.projetoBar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projetoBar.model.ProdutoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExibirProdutoDTO {

    @JsonProperty("id")
    private Integer id;


    @JsonProperty(value = "nome")
    private String nome;


    @JsonProperty(value = "valorDeVenda")
    private Double valorDeVenda;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("tipoGenerico")
    private String tiposGenericosEnum;

    public ExibirProdutoDTO(ProdutoModel produtoModel){

        this.id = produtoModel.getId();
        this.nome = produtoModel.getNome();
        this.valorDeVenda = produtoModel.getValorDeVenda();
        this.tipo = produtoModel.getTipo();
        this.tiposGenericosEnum = produtoModel.getTiposGenericos();

    }
}
