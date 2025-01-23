package com.thiaghoul.supermarket.entities;

import com.thiaghoul.supermarket.entities.pk.ProdutoCategoriaPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_produto_categoria")
public class ProdutoCategoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @EqualsAndHashCode.Include
    private ProdutoCategoriaPk id = new ProdutoCategoriaPk();

    public ProdutoCategoria(){

    }

    public ProdutoCategoria(Produto produto, Categoria categoria){
        id.setProduto(produto);
        id.setCategoria(categoria);
    }

}
