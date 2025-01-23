package com.thiaghoul.supermarket.entities;

import com.thiaghoul.supermarket.entities.pk.PedidoProdutoPk;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_pedido_produto")
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

    public Pedido getPedido(){
        return id.getPedido();
    }

    public void setPedido(Pedido pedido){
        id.setPedido(pedido);
    }

    public Produto getProduto(){
        return id.getProduto();
    }

    public void setProduto(Produto produto){
        id.setProduto(produto);
    }


}
