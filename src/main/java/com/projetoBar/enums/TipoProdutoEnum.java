package com.projetoBar.enums;

public enum TipoProdutoEnum {

    CERVEJA("CERVEJA"),
    REFRIGERANTE("REFRIGERANTE"),
    VODKA("VODKA"),
    WHISKY("WHISKY"),
    GIN("GIN"),
    AGUA("AGUA"),
    CHOPP("CHOPP"),
    DRINKS("DRINKS"),
    ESPECIAIS("ESPECIAIS"),
    CACHACA("CACHACA"),
    ENERGETICO("ENERGETICO"),
    PORCAO("PORCAO"),
    DOCES("DOCES"),
    ROSH("ROSH");

    private String tipoProduto;

    TipoProdutoEnum(String tipoProduto){

        this.tipoProduto = tipoProduto;

    }

    public String getTipoProduto(){
        return this.tipoProduto;
    }
}
