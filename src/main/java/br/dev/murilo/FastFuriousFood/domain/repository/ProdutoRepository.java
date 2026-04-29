package br.dev.murilo.FastFuriousFood.domain.repository;

import br.dev.murilo.FastFuriousFood.domain.model.Produto;
import br.dev.murilo.FastFuriousFood.domain.model.enums.CategoriaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    // Este método permite filtrar os produtos pela categoria no banco
    List<Produto> findByCategoria(CategoriaProduto categoria);
}