package com.thiaghoul.supermarket.entities;

import com.thiaghoul.supermarket.entities.pk.ProdutoFornecedorPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProdutoFornecedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @EqualsAndHashCode.Include
    private ProdutoFornecedorPk id = new ProdutoFornecedorPk();

    private double precoFornecedor;

    public ProdutoFornecedor(){

    }

    public ProdutoFornecedor(Produto produto, Fornecedor fornecedor,
                             double precoFornecedor){
        id.setProduto(produto);
        id.setFornecedor(fornecedor);
        this.precoFornecedor = precoFornecedor;
    }





}
