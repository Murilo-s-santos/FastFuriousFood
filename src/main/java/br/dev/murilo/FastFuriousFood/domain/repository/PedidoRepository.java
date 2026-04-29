package br.dev.murilo.FastFuriousFood.domain.repository;

import br.dev.murilo.FastFuriousFood.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}