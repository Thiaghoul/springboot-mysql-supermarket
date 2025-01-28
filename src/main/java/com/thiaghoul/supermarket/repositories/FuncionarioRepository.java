package com.thiaghoul.supermarket.repositories;

import com.thiaghoul.supermarket.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {
}
