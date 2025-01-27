package com.thiaghoul.supermarket.repositories;

import com.thiaghoul.supermarket.entities.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Long> {
}
