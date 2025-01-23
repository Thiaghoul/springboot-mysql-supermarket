package com.thiaghoul.supermarket.entities;

import com.thiaghoul.supermarket.entities.pk.PedidoProdutoPk;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PedidoProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @EqualsAndHashCode.Include
    private PedidoProdutoPk id = new PedidoProdutoPk();

    private Integer quantidade;

    private Double preco;

    public PedidoProduto() {

    }

    public PedidoProduto(Pedido pedido, Produto produto, int quantidade, double preco){
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public double getSubTotal(){
        return quantidade * preco;
    }


}
