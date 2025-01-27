package com.thiaghoul.supermarket.entities;

import com.thiaghoul.supermarket.entities.enums.Cargo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_funcionario")
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private String id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double salario;

    @Column(nullable = false)
    private Cargo cargo;

    @OneToMany (mappedBy = "funcionario")
    private List<Pedido> pedidos = new ArrayList<>();

}
