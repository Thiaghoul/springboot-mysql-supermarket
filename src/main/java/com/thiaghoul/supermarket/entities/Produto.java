package com.thiaghoul.supermarket.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "tb_produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    private Date dataValidade;

    private int quantidade;

    @OneToMany(mappedBy = "id.produto")
    private Set<PedidoProduto> pedidosProdutos = new HashSet<>();


}
