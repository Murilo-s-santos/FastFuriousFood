package br.dev.murilo.FastFuriousFood.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ItensPedido 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int qtd;
    private double valUnit;

    /*public ItensPedido(long id, int qtd, double valUnit) 
    {
        this.id = id;
        this.qtd = qtd;
        this.valUnit = valUnit;
    }*/
    public ItensPedido()
    {
        
    }
    
     
    
}
