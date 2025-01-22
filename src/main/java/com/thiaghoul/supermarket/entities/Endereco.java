package com.thiaghoul.supermarket.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Endereco {

    @Id
    private int id;

    private String rua;
    private String cep;
    private String numero;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

}
