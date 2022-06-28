package com.petshop.PetShopAlpha.model.produto;

import com.petshop.PetShopAlpha.model.cliente.Cliente;
import com.petshop.PetShopAlpha.model.funcionario.Funcionario;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Entity(name = "pedido_compra")
@Table(name = "pedido_compra")
public class PedidoCompra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pedido_compra_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal totalPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    private Funcionario funcionario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    public BigDecimal calcularTotalPedido(BigDecimal valor, Integer quantidade){
       this.totalPedido = valor.multiply(BigDecimal.valueOf(quantidade));
       return this.totalPedido;
    }

    public PedidoCompra(BigDecimal totalPedido, Funcionario funcionario, Cliente cliente) {
        this.totalPedido = totalPedido;
        this.funcionario = funcionario;
        this.cliente = cliente;
    }

    public PedidoCompra(BigDecimal totalPedido, Cliente cliente) {
        this.totalPedido = totalPedido;
        this.cliente = cliente;
    }

    public PedidoCompra(Long id, BigDecimal totalPedido, Cliente cliente) {
        this.id = id;
        this.totalPedido = totalPedido;
        this.cliente = cliente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
