package com.petshop.PetShopAlpha.repository.produto;

import com.petshop.PetShopAlpha.model.embeddable.ItensPedidoCompraPK;
import com.petshop.PetShopAlpha.model.produto.ItensPedidoCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidoCompraRepository extends JpaRepository<ItensPedidoCompra, ItensPedidoCompraPK> {
}
