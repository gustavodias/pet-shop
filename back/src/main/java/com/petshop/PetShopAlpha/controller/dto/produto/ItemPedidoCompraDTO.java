package com.petshop.PetShopAlpha.controller.dto.produto;

import com.petshop.PetShopAlpha.model.produto.ItensPedidoCompra;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemPedidoCompraDTO {
    private Long idPedido;
    private Long idProduto;
    private String produto;
    private Integer quantitade;
    private BigDecimal valorUnitario;
    private BigDecimal total;
    private String cliente;

    public ItemPedidoCompraDTO(ItensPedidoCompra itens) {
        this.idPedido = itens.getPedidoCompra().getId();
        this.idProduto = itens.getProduto().getId();
        this.quantitade = itens.getQuantidade();
        this.produto = itens.getProduto().getNome();
        this.valorUnitario = itens.getProduto().getValor();
        this.total = itens.getPedidoCompra().getTotalPedido();
        this.cliente = itens.getPedidoCompra().getCliente().getUsuario().getNome();
    }
}
