package com.thiaghoul.supermarket.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String rua;
    private String cep;
    private String numero;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

}
