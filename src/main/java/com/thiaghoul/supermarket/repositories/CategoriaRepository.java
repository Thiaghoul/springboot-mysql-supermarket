package com.thiaghoul.supermarket.repositories;

import com.thiaghoul.supermarket.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
