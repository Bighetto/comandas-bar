package com.projetoBar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projetoBar.enums.TipoProdutoEnum;
import com.projetoBar.model.dto.ProdutoInsertDTO;
import lombok.*;

import javax.persistence.*;

@Table(name = "produto")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    public ProdutoModel(ProdutoInsertDTO dto){

        this.nome = dto.getNome();
        this.valorDeCusto = dto.getValorDeCusto();
        this.valorDeVenda = dto.getValorDeVenda();
        this.tipo = dto.getTipo();

    }

}
