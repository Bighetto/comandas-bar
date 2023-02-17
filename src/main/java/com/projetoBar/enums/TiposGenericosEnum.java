package com.projetoBar.enums;

public enum TiposGenericosEnum {

    BEBIDAS("BEBIDAS"),
    ESSENCIAS("ESSENCIAS"),
    PORCOES("PORCOES"),
    DOCES("DOCES");

    private String tipoGenerico;

    TiposGenericosEnum(String tipoGenerico){

        this.tipoGenerico = tipoGenerico;

    }

    public String getTipoGenerico(){
        return this.tipoGenerico;
    }

}
