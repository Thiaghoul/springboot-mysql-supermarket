package com.thiaghoul.supermarket.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Fornecedor {

    @Id
    private String id;

    private String nome;



}
