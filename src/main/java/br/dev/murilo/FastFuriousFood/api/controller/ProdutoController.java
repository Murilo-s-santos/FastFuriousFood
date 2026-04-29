package br.dev.murilo.FastFuriousFood.api.controller;

import br.dev.murilo.FastFuriousFood.domain.model.Produto;
import br.dev.murilo.FastFuriousFood.domain.model.enums.CategoriaProduto;
import br.dev.murilo.FastFuriousFood.domain.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fastfurious/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionar( @RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produtoDados) {
        Optional<Produto> produtoAtual = produtoRepository.findById(id);

        if (produtoAtual.isPresent()) {
            BeanUtils.copyProperties(produtoDados, produtoAtual.get(), "id");
            Produto produtoSalvo = produtoRepository.save(produtoAtual.get());
            return ResponseEntity.ok(produtoSalvo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!produtoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cat/{categoria}")
    public List<Produto> listarPorCategoria(@PathVariable CategoriaProduto categoria) {
        return produtoRepository.findByCategoria(categoria);
    }
}