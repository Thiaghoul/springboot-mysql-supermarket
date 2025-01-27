package com.thiaghoul.supermarket.entities;

import com.thiaghoul.supermarket.entities.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Date pedidoMomento;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @OneToMany(mappedBy = "id.pedido")
    private Set<PedidoProduto> pedidosProdutos = new HashSet<>();

}
