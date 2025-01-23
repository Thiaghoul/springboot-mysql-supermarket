package com.thiaghoul.supermarket.entities.pk;

import com.thiaghoul.supermarket.entities.Pedido;
import com.thiaghoul.supermarket.entities.PedidoProduto;
import com.thiaghoul.supermarket.entities.Produto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class PedidoProdutoPk implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;


}
