package com.thiaghoul.supermarket.repositories;

import com.thiaghoul.supermarket.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
