package com.thiaghoul.supermarket.repositories;

import com.thiaghoul.supermarket.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
