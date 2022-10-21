package com.projetoBar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projetoBar.enums.TipoProdutoEnum;
import lombok.*;

import javax.persistence.*;

@Table(name = "produto")
@Entity
@Data
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduto")
    private Integer id;

    @Column(name = "nome")
    @JsonProperty(value = "nome")
    private String nome;

    @Column(name = "valor_de_custo")
    @JsonProperty(value = "valorDeCusto")
    private Double valorDeCusto;

    @Column(name = "valor_de_venda")
    @JsonProperty(value = "valorDeVenda")
    private Double valorDeVenda;

    @Column(name = "tipo")
    @JsonProperty("tipo")
    private TipoProdutoEnum tipo;
}
