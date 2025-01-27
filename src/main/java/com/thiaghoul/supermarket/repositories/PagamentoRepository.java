package com.thiaghoul.supermarket.repositories;

import com.thiaghoul.supermarket.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
