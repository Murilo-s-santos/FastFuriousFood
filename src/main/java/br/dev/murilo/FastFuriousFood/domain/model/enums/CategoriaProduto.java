package br.dev.murilo.FastFuriousFood.domain.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CategoriaProduto 
{
    LANCHE,
    BEBIDA,
    ACOMPANHAMENTO,
    SOBREMESA;
    
    @JsonCreator
    public static CategoriaProduto fromValue(String value)
    {
        if(value == null) return null;
        return CategoriaProduto.valueOf(value.toUpperCase());
    }
}
