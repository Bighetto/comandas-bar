package com.projetoBar.model;

import com.projetoBar.dto.ProdutoInsertDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String nome;

    @Column(name = "valor_de_custo")
    private Double valorDeCusto;

    @Column(name = "valor_de_venda")
    private Double valorDeVenda;


    @Column(name = "tipo")
    private String tipo;

    @Column(name = "tipo_generico")
    private String tiposGenericos;

    public ProdutoModel(ProdutoInsertDTO dto){

        this.nome = dto.getNome();
        this.valorDeCusto = dto.getValorDeCusto();
        this.valorDeVenda = dto.getValorDeVenda();
        this.tipo = dto.getTipo().getTipoProduto();
        this.tiposGenericos = dto.getTipoGenerico().getTipoGenerico();

    }



}
