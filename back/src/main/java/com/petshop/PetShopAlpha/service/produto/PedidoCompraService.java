package com.petshop.PetShopAlpha.service.produto;

import com.petshop.PetShopAlpha.controller.dto.produto.PedidoCompraDTO;
import com.petshop.PetShopAlpha.model.cliente.Cliente;
import com.petshop.PetShopAlpha.model.funcionario.Funcionario;
import com.petshop.PetShopAlpha.model.produto.ItensPedidoCompra;
import com.petshop.PetShopAlpha.model.produto.PedidoCompra;
import com.petshop.PetShopAlpha.model.produto.Produto;
import com.petshop.PetShopAlpha.repository.produto.PedidoCompraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PedidoCompraService {

    private final PedidoCompraRepository repository;

    public List<PedidoCompraDTO> findAll(){
        var list = repository.findAll();
        return list.stream().map(PedidoCompraDTO::new).collect(Collectors.toList());
    }



    public PedidoCompra savePedidoCompra(Cliente cliente) {
        return repository.save(new PedidoCompra(new BigDecimal("0.0"), cliente));
    }
}
