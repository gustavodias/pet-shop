package com.petshop.PetShopAlpha.controller;
import com.petshop.PetShopAlpha.controller.dto.funcionario.CargoDTO;
import com.petshop.PetShopAlpha.controller.form.funcionario.CargoForm;
import com.petshop.PetShopAlpha.controller.form.funcionario.CargoUpdateForm;
import com.petshop.PetShopAlpha.service.funcionario.CargoService;
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
@RequestMapping("/api/cargo")
@CrossOrigin(origins = "*")
@Api(value = "Pet Shop - API")
@AllArgsConstructor
public class CargoController {

    private final CargoService service;

    @GetMapping
    @ApiOperation(value="Retorna uma lista de Funcionarios")
    public ResponseEntity<List<CargoDTO>> findAllCargos(){
        var listFunc = service.findAll();
        if (listFunc.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(listFunc);
        }
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="Retorna um Cargo com o parametro ID passado")
    public ResponseEntity<CargoDTO> findOneCargo(@PathVariable("id") Long id){
        var cargo = service.findByIdCargo(id);

        return cargo.map(value -> ResponseEntity.ok(new CargoDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/cadastro")
    @ApiOperation(value="Cria uma novo Cargo")
    public ResponseEntity<CargoDTO> saveCandidato(@RequestBody @Valid CargoForm form, UriComponentsBuilder uriComponentsBuilder){
        var cargoDto = service.saveCargo(form);
        URI uri = uriComponentsBuilder.path("cargo/{id}").buildAndExpand(cargoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(new CargoDTO(cargoDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Atualiza uma Cargo pelo parametro ID passado")
    public ResponseEntity<CargoDTO> updateCandidato(@PathVariable("id") Long id,
                                                     @RequestBody @Valid CargoUpdateForm cargoUpdateForm){
        var optionalCargo = service.findByIdCargo(id);

        if (optionalCargo.isPresent()){
            return ResponseEntity.ok(service.update(id, cargoUpdateForm));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta uma Cargo")
    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Long id){
        var optionalCargo = service.findByIdCargo(id);
        if (optionalCargo.isPresent()){
            service.delete(optionalCargo.get());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
