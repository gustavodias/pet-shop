package com.petshop.PetShopAlpha.controller;

import com.petshop.PetShopAlpha.controller.dto.pet.PetServicosDTO;
import com.petshop.PetShopAlpha.controller.dto.produto.ItemPedidoCompraDTO;
import com.petshop.PetShopAlpha.controller.form.pet.PetServicosForm;
import com.petshop.PetShopAlpha.controller.form.produto.ItemAllForm;
import com.petshop.PetShopAlpha.service.pet.PetServicosService;
import com.petshop.PetShopAlpha.service.produto.ItensPedidoCompraService;
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
@RequestMapping("/api/petservicos")
@CrossOrigin(origins = "*")
@Api(value = "Pet Shop - API")
@AllArgsConstructor
public class PetServicosController {

    private final PetServicosService service;

    @GetMapping
    @ApiOperation(value="Retorna uma lista de Pedidos")
    public ResponseEntity<List<PetServicosDTO>> findAll(){
        var list = service.findAll();
        if (list.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(list);
        }
    }

    @PostMapping(value = "/salvar")
    @ApiOperation(value="Criar um novo Pedido com todos os dados")
    public ResponseEntity<PetServicosDTO> saveAllDados(@RequestBody @Valid PetServicosForm dados,
                                                       UriComponentsBuilder uriComponentsBuilder) throws ParseException {
        var dto = service.save(dados);
        URI uri = uriComponentsBuilder.path("petservicos/{id}").buildAndExpand(dto.getIdPet()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
