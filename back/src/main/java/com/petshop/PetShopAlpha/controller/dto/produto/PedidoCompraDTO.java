package com.petshop.PetShopAlpha.controller.dto.produto;

import com.petshop.PetShopAlpha.model.produto.PedidoCompra;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PedidoCompraDTO {
    private Long id;
    private String produto;
    private BigDecimal valorUnitario;
    private Integer quantidade;
    private BigDecimal total;
    private String funcionario;
    private String cliente;

    public PedidoCompraDTO(PedidoCompra pedidoCompra) {
        this.id = pedidoCompra.getId();
        this.total = pedidoCompra.getTotalPedido();
        this.funcionario = pedidoCompra.getFuncionario().getUsuario().getNome();
        this.cliente = pedidoCompra.getCliente().getUsuario().getNome();
    }
}
