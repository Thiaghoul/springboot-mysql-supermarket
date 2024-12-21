package com.thiaghoul.supermarket.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Produto {

    @Id
    private String id;

    private String nome;
    private Double preco;
    private Date dataValidade;
    private int quantidade;


}
