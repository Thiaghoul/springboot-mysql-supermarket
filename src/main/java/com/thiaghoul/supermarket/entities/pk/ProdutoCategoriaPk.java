package com.thiaghoul.supermarket.entities.pk;

import com.thiaghoul.supermarket.entities.Categoria;
import com.thiaghoul.supermarket.entities.Produto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ProdutoCategoriaPk implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
