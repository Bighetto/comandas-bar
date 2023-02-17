package com.projetoBar.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projetoBar.enums.TipoProdutoEnum;
import com.projetoBar.enums.TiposGenericosEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoInsertDTO {

    @JsonProperty(value = "nome")
    private String nome;

    @JsonProperty(value = "valorDeCusto")
    private Double valorDeCusto;

    @JsonProperty(value = "valorDeVenda")
    private Double valorDeVenda;

    @JsonProperty("tipo")
    private TipoProdutoEnum tipo;

    @JsonProperty("tipoGenerico")
    private TiposGenericosEnum tipoGenerico;
}
