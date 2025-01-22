package com.thiaghoul.supermarket.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;
    private Double salario;
    private Cargo cargo;

    @OneToMany (mappedBy = "funcionario")
    private List<Pedido> pedidos = new ArrayList<>();

}
