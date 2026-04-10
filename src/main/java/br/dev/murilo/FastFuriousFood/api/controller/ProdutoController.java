package br.dev.murilo.FastFuriousFood.api.controller;

import br.dev.murilo.FastFuriousFood.domain.model.Produto;
import br.dev.murilo.FastFuriousFood.domain.repository.ProdutoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController 
{
    /*@PersistenceContext
    private EntityManager manager;*/
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @GetMapping("/produtos")
    public List<Produto> listas() 
    {
        //return manager.createQuery("from Produto", Produto.class).getResultList();
        return produtoRepository.findAll();
    }
    
}
