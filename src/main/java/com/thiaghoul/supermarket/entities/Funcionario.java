package com.thiaghoul.supermarket.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Funcionario {

    @Id
    private String id;

    private String nome;
    private Double salario;
    private Cargo cargo;

    @OneToMany
    private List<Pedido> pedidos;

}
