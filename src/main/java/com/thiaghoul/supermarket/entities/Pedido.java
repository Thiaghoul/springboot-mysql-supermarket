package com.thiaghoul.supermarket.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {

    @Id
    private String id;



    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Funcionario funcionario;
}
