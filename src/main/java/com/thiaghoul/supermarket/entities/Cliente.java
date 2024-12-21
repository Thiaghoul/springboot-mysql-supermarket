package com.thiaghoul.supermarket.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Cliente {

    @Id
    private int id;

    private String nome;
    private String email;
    private String telefone;
    private String endereco;

    @OneToMany
    private List<Pedido> pedidos;



}
