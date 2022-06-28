package com.petshop.PetShopAlpha.controller;

import com.petshop.PetShopAlpha.controller.dto.cliente.ClienteDTO;
import com.petshop.PetShopAlpha.controller.form.cliente.ClienteAllForm;
import com.petshop.PetShopAlpha.service.ClienteService;
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
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
@Api(value = "Pet Shop - API")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @GetMapping
    @ApiOperation(value="Retorna uma lista de Clientes")
    public ResponseEntity<List<ClienteDTO>> findAll(){
        var listCliente = service.findAll();
        if (listCliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(listCliente);
        }
    }

    @PostMapping(value = "/cadastro")
    @ApiOperation(value="Criar um novo Cliente com todos os dados")
    public ResponseEntity<ClienteDTO> saveAllDados(@RequestBody @Valid ClienteAllForm dados,
                                                       UriComponentsBuilder uriComponentsBuilder) throws ParseException {
        var clienteDTO = service.saveCliente(dados);
        URI uri = uriComponentsBuilder.path("cliente/{id}").buildAndExpand(clienteDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteDTO);
    }
}
