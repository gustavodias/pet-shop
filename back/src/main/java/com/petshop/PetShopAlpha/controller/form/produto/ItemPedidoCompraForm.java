package com.petshop.PetShopAlpha.controller.form.produto;

import com.petshop.PetShopAlpha.model.embeddable.ItensPedidoCompraPK;
import com.petshop.PetShopAlpha.model.produto.ItensPedidoCompra;
import com.petshop.PetShopAlpha.model.produto.PedidoCompra;
import com.petshop.PetShopAlpha.model.produto.Produto;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class ItemPedidoCompraForm {
    @NotNull
    private Integer quantidade;

    public ItensPedidoCompra converter(Produto produto, PedidoCompra pedidoCompra){
        var itensPedidoCompraPK = new ItensPedidoCompraPK(produto.getId(), pedidoCompra.getId());
        return new ItensPedidoCompra(itensPedidoCompraPK, pedidoCompra, produto, quantidade);
    }
}
