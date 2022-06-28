package com.petshop.PetShopAlpha.controller;

import com.petshop.PetShopAlpha.controller.dto.funcionario.CargoDTO;
import com.petshop.PetShopAlpha.controller.dto.funcionario.FuncionarioDTO;
import com.petshop.PetShopAlpha.controller.form.funcionario.FuncionarioAllForm;
import com.petshop.PetShopAlpha.controller.form.funcionario.FuncionarioUpdateForm;
import com.petshop.PetShopAlpha.service.funcionario.CargoService;
import com.petshop.PetShopAlpha.service.funcionario.FuncionarioService;
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
@RequestMapping("/api/funcionario")
@CrossOrigin(origins = "*")
@Api(value = "Pet Shop - API")
@AllArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;
    private final CargoService serviceCargo;

    @GetMapping
    @ApiOperation(value="Retorna uma lista de Funcionarios")
    public ResponseEntity<List<FuncionarioDTO>> findAll(){
        var listFunc = service.findAll();
        if (listFunc.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(listFunc);
        }
    }

    @GetMapping(value = "/cargos")
    @ApiOperation(value="Retorna uma lista de Funcionarios")
    public ResponseEntity<List<CargoDTO>> findAllCargos(){
        var listFunc = serviceCargo.findAll();
        if (listFunc.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(listFunc);
        }
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="Retorna um Funcionario com o parametro ID passado")
    public ResponseEntity<FuncionarioDTO> findOneCandidato(@PathVariable("id") Long id){
        var funcionario = service.findByIdFuncionario(id);

        return funcionario.map(value -> ResponseEntity.ok(new FuncionarioDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/cadastro")
    @ApiOperation(value="Criar um novo Funcionario com todos os dados")
    public ResponseEntity<FuncionarioDTO> saveAllDados(@RequestBody @Valid FuncionarioAllForm dados,
                                                       UriComponentsBuilder uriComponentsBuilder) throws ParseException {
        var funcionarioDTO = service.saveFuncionario(dados);
        URI uri = uriComponentsBuilder.path("funcionario/{id}").buildAndExpand(funcionarioDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(funcionarioDTO);
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Atualiza um Funcionario pelo parametro ID passado")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable("id") Long id,
                                                 @RequestBody @Valid FuncionarioUpdateForm form){
        var optionalFuncionario = service.findByIdFuncionario(id);

        if (optionalFuncionario.isPresent()){
            return ResponseEntity.ok(service.updateFuncionario(id, form));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
