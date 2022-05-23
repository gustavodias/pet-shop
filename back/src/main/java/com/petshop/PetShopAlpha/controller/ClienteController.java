package com.petshop.PetShopAlpha.controller;

import com.petshop.PetShopAlpha.controller.form.cliente.ClienteAllParamForm;
import com.petshop.PetShopAlpha.controller.dto.cliente.ClienteFullDTO;
import com.petshop.PetShopAlpha.repository.ClienteRepository;
import com.petshop.PetShopAlpha.service.ClienteService;
import com.petshop.PetShopAlpha.service.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value="Retorna uma lista de Clientes")
    public ResponseEntity<List<ClienteFullDTO>> fildAllDadosClientes(){
        var listCliente = service.findAll();
        if (listCliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(listCliente);
        }
    }

    @PostMapping(value = "/cadastro")
    @ApiOperation(value="Criar um novo Cliente com todos os dados")
    public ResponseEntity<ClienteFullDTO> saveAllDados(@RequestBody @Valid ClienteAllParamForm dados,
                                                   UriComponentsBuilder uriComponentsBuilder) throws ParseException {
        var clienteFullDTO = service.saveClienteAllParam(dados);
        URI uri = uriComponentsBuilder.path("cliente/{id}").buildAndExpand(clienteFullDTO.getIdCliente()).toUri();
        return ResponseEntity.ok(clienteFullDTO);
    }
}
