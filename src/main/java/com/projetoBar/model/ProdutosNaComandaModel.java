package com.projetoBar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "produtos_na_comanda")
public class ProdutosNaComandaModel {


    @Id
    @Column(name = "idcomanda")
    @JsonProperty("idcomanda")
    private Integer idcomanda;

    @Column(name = "valor_produto")
    @JsonProperty("valorProduto")
    private Double valorProduto;

    @Column(name = "nome_produto")
    @JsonProperty("nomeProduto")
    private String nomeProduto;

    @Column(name = "fk_idproduto")
    @JsonProperty("idProduto")
    private Integer idProduto;

    @Column(name = "quantidade")
    @JsonProperty("quantidade")
    private Integer quantidade;
}
