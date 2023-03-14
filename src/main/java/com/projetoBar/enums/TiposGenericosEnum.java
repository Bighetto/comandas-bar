package com.projetoBar.enums;

public enum TiposGenericosEnum {

    BEBIDAS("BEBIDAS"),
    ESSENCIAS("ESSENCIAS"),
    PORCOES("PORCOES"),
    DOCES("DOCES"),
    PROMOCAO("PROMOCAO");

    private String tipoGenerico;

    TiposGenericosEnum(String tipoGenerico){

        this.tipoGenerico = tipoGenerico;

    }

    public String getTipoGenerico(){
        return this.tipoGenerico;
    }

}
