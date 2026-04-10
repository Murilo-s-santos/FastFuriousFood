package br.dev.murilo.FastFuriousFood.domain.repository;

import br.dev.murilo.FastFuriousFood.domain.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>
{
    List<Produto> findByNome(String nome);
    List<Produto> findByNomeContaining(String nome);  
    
}
