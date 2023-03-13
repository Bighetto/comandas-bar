package com.projetoBar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "produtos_na_comanda")
public class ProdutosNaComandaModel {


    @Column(name = "idcomanda")
    @JsonProperty("idcomanda")
    private Integer idcomanda;

    @Column(name = "valor_produto")
    @JsonProperty("valorProduto")
    private Double valorProduto;

    @Column(name = "nome_produto")
    @JsonProperty("nomeProduto")
    private String nomeProduto;



    @Column(name = "quantidade")
    @JsonProperty("quantidade")
    private Integer quantidade;

    @Column(name = "data_comanda")
    @JsonProperty("dataComanda")
    private Timestamp dataComanda;

    @Id
    @Column(name = "identificador")
    @JsonProperty("identificador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;


}
