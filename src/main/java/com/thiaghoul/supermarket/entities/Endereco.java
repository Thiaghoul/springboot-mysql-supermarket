package com.thiaghoul.supermarket.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Endereco {

    @Id
    private int id;

    private String rua;
    private String cep;
    private String numero;

}
