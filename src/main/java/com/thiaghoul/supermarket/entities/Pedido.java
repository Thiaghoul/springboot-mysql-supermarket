package com.thiaghoul.supermarket.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Date pedidoMomento;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;
}
