package com.thiaghoul.supermarket.repositories;

import com.thiaghoul.supermarket.entities.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
