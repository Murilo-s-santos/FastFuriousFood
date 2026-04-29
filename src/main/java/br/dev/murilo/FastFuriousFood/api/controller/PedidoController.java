package br.dev.murilo.FastFuriousFood.api.controller;

import br.dev.murilo.FastFuriousFood.domain.model.Pedido;
import br.dev.murilo.FastFuriousFood.domain.model.enums.StatusPedido;
import br.dev.murilo.FastFuriousFood.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fastfurious/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido adicionar( @RequestBody Pedido pedido) {
        pedido.setStatus(StatusPedido.ABERTO);
        pedido.setDtAberto(LocalDateTime.now());
        
        // Dica: Vincular o pedido aos itens para salvar em cascata
        if (pedido.getItens() != null) {
            pedido.getItens().forEach(item -> item.setPedido(pedido));
        }
        
        return pedidoRepository.save(pedido);
    }

    // 5.1.2 - Altera o status do Pedido (Terminal de Preparo/Entrega)
    @PutMapping("/status/{id}")
    public ResponseEntity<Pedido> alterarStatus(@PathVariable Long id, @RequestBody StatusPedido novoStatus) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (pedidoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Pedido pedido = pedidoOptional.get();
        pedido.setStatus(novoStatus);

        // Lógica de datas baseada no status
        if (novoStatus == StatusPedido.PRONTO) {
            pedido.setDtPronto(LocalDateTime.now());
        } else if (novoStatus == StatusPedido.ENTREGUE) {
            pedido.setDtEntregue(LocalDateTime.now());
        }

        return ResponseEntity.ok(pedidoRepository.save(pedido));
    }

    // 5.1.2 - CANCELA pedido (DELETE vira cancelamento lógico)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setStatus(StatusPedido.CANCELADO);
            pedidoRepository.save(pedido);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}