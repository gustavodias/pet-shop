package com.petshop.PetShopAlpha.service.produto;

import com.petshop.PetShopAlpha.controller.dto.produto.ItemPedidoCompraDTO;
import com.petshop.PetShopAlpha.controller.form.produto.ItemAllForm;
import com.petshop.PetShopAlpha.model.embeddable.ItensPedidoCompraPK;
import com.petshop.PetShopAlpha.model.produto.ItensPedidoCompra;
import com.petshop.PetShopAlpha.model.produto.PedidoCompra;
import com.petshop.PetShopAlpha.repository.produto.ItensPedidoCompraRepository;
import com.petshop.PetShopAlpha.repository.produto.PedidoCompraRepository;
import com.petshop.PetShopAlpha.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItensPedidoCompraService {

    private final ItensPedidoCompraRepository repository;
    private final ProdutoService produtoService;
    private final PedidoCompraService pedidoCompraService;
    private final PedidoCompraRepository pedidoCompraRepository;
    private final ClienteService clienteService;

    public List<ItemPedidoCompraDTO> findAll(){
        var list = repository.findAll();
        return list.stream().map(ItemPedidoCompraDTO::new).collect(Collectors.toList());
    }

    public ItemPedidoCompraDTO savePedidoCompra(ItemAllForm form) {
        var produto = produtoService.findById(form.getIdProduto());
        var cliente = clienteService.findById(form.getIdCliente());
        var pedidoCompra  = pedidoCompraRepository.save(new PedidoCompra());

        var itensPedidoCompraPK = new ItensPedidoCompraPK(pedidoCompra.getId(), produto.get().getId());
        var itemPedidoCompra = new ItensPedidoCompra(itensPedidoCompraPK, pedidoCompra, produto.get(), form.getItemPedidoCompra().getQuantidade());
        pedidoCompra.calcularTotalPedido(produto.get().getValor(), itemPedidoCompra.getQuantidade());
        pedidoCompra.setCliente(cliente.get());

        pedidoCompraRepository.save(pedidoCompra);
        repository.save(itemPedidoCompra);
        return new ItemPedidoCompraDTO(itemPedidoCompra);
    }
}
