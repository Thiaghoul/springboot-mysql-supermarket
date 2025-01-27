package com.thiaghoul.supermarket.repositories;

import com.thiaghoul.supermarket.entities.ProdutoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoCategoriaRepository extends JpaRepository<ProdutoCategoria, Long> {
}
