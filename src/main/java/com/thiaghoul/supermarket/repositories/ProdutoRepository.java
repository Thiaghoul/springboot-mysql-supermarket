package com.thiaghoul.supermarket.repositories;

import com.thiaghoul.supermarket.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
