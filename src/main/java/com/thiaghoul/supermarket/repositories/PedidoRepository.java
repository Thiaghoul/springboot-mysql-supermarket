package com.thiaghoul.supermarket.repositories;

import com.thiaghoul.supermarket.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
