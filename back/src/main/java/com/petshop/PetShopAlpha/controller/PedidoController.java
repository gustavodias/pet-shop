package com.petshop.PetShopAlpha.controller;

import com.petshop.PetShopAlpha.controller.dto.cliente.ClienteDTO;
import com.petshop.PetShopAlpha.controller.dto.produto.ItemPedidoCompraDTO;
import com.petshop.PetShopAlpha.controller.dto.produto.PedidoCompraDTO;
import com.petshop.PetShopAlpha.controller.form.cliente.ClienteAllForm;
import com.petshop.PetShopAlpha.controller.form.produto.ItemAllForm;
import com.petshop.PetShopAlpha.controller.form.produto.ItemPedidoCompraForm;
import com.petshop.PetShopAlpha.service.ClienteService;
import com.petshop.PetShopAlpha.service.produto.ItensPedidoCompraService;
import com.petshop.PetShopAlpha.service.produto.PedidoCompraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = "*")
@Api(value = "Pet Shop - API")
@AllArgsConstructor
public class PedidoController {

    private final ItensPedidoCompraService service;

    @GetMapping
    @ApiOperation(value="Retorna uma lista de Pedidos")
    public ResponseEntity<List<ItemPedidoCompraDTO>> findAll(){
        var list = service.findAll();
        if (list.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(list);
        }
    }

    @PostMapping(value = "/salvar")
    @ApiOperation(value="Criar um novo Pedido com todos os dados")
    public ResponseEntity<ItemPedidoCompraDTO> saveAllDados(@RequestBody @Valid ItemAllForm dados,
                                                       UriComponentsBuilder uriComponentsBuilder) throws ParseException {
        var dto = service.savePedidoCompra(dados);
        URI uri = uriComponentsBuilder.path("cliente/{id}").buildAndExpand(dto.getIdPedido()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
