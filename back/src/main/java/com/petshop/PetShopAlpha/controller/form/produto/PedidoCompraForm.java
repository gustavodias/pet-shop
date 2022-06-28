package com.petshop.PetShopAlpha.controller.form.produto;

import com.petshop.PetShopAlpha.model.cliente.Cliente;
import com.petshop.PetShopAlpha.model.funcionario.Funcionario;
import com.petshop.PetShopAlpha.model.produto.ItensPedidoCompra;
import com.petshop.PetShopAlpha.model.produto.PedidoCompra;
import com.petshop.PetShopAlpha.model.produto.Produto;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
public class PedidoCompraForm {

    public PedidoCompra converter(Cliente cliente,Produto produto, ItensPedidoCompra itensPedidoCompra){
        return new PedidoCompra(new BigDecimal(BigInteger.ZERO), cliente);
    }
}
