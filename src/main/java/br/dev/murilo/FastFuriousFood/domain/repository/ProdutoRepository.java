package br.dev.murilo.FastFuriousFood.domain.repository;

import br.dev.murilo.FastFuriousFood.domain.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>
{
   List<Produto> findByNome(String nome);
   List<Produto> findByNomeContaining(String nome);  
    
}

/*

use mss_fast_furious_food;

INSERT INTO Produto (nome, preco, ingredientes)
VALUES 
('Turbo Burger', '29.90' ,'pao brioche, hamburger 150g, queijo chedar, alface, tomate, molho especial'),
('Nitro Bacon Blast', '34.90' ,'pao australiano, hamburger 180g, bacon crocante, cheddar, cebola caramellizada molho barbecue'),
('V8 Power Burger', '39.90', 'pao brioche, dois hamburgers 120g, queijo prato, bacon, ovo, alface, tomate, maionese'),
('Drift Chicken Burger', '27.90', 'pao brioche, frango empanado, alface, tomate, maionese temperada'),
('Street Racer Veggie', '26.90', 'pao integral, hamburger vegetal, alface, tomate, cebola roxa, molho vegetariano');


select * from Produto;
*/
