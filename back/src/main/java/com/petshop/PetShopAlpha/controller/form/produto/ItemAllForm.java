package com.petshop.PetShopAlpha.controller.form.produto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemAllForm {
    private Long idProduto;
    private Long idCliente;
    private ItemPedidoCompraForm itemPedidoCompra;

    public ItemAllForm(Long idProduto, Long idCliente, ItemPedidoCompraForm itemPedidoCompra) {
        this.idProduto = idProduto;
        this.idCliente = idCliente;
        this.itemPedidoCompra = itemPedidoCompra;
    }
}
