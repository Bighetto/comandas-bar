package com.projetoBar.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ExibirTudoNaComandaDTO {

    private Integer idComanda;

    private Double valorTotal;

    private List<ProdutosNaComandaDTO> listaDeProdutos;

    public ExibirTudoNaComandaDTO (Integer id, Double valorTotal, List<ProdutosNaComandaDTO>listaDeProdutos){

        this.idComanda = id;
        this.valorTotal = valorTotal;
        this.listaDeProdutos = listaDeProdutos;

    }
}
