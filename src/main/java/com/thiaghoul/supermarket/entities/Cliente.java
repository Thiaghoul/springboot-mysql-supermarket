package com.thiaghoul.supermarket.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cliente {

    @Id
    private int id;

    private String nome;
    private String email;
    private String telefone;

    @OneToOne
    private Endereco endereco;

    @OneToMany
    private List<Pedido> pedidos;



}
