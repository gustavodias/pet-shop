package com.petshop.PetShopAlpha.controller.endereco;

import com.petshop.PetShopAlpha.controller.dto.endereco.EstadoDTO;
import com.petshop.PetShopAlpha.controller.form.endereco.create.EstadoForm;
import com.petshop.PetShopAlpha.controller.form.endereco.update.EstadoUpdateForm;
import com.petshop.PetShopAlpha.service.endereco.EstadoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/estado")
@CrossOrigin(origins = "*")
@Api(value = "Pet Shop - API")
@AllArgsConstructor
public class EstadoController {

    private final EstadoService service;

    @GetMapping
    @ApiOperation(value="Retorna uma lista de Funcionarios")
    public ResponseEntity<List<EstadoDTO>> findAllEstados(){
        var listFunc = service.findAll();
        if (listFunc.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(listFunc);
        }
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="Retorna um Estado com o parametro ID passado")
    public ResponseEntity<EstadoDTO> findOneEstado(@PathVariable("id") Long id){
        var estado = service.findByID(id);
        return estado.map(value -> ResponseEntity.ok(new EstadoDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/cadastro")
    @ApiOperation(value="Cria um novo Estado")
    public ResponseEntity<EstadoDTO> saveCandidato(@RequestBody @Valid EstadoForm form, UriComponentsBuilder uriComponentsBuilder){
        var estadoDto = service.save(form);
        URI uri = uriComponentsBuilder.path("estado/{id}").buildAndExpand(estadoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(estadoDto);
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Atualiza uma Estado pelo parametro ID passado")
    public ResponseEntity<EstadoDTO> updateCandidato(@PathVariable("id") Long id,
                                                     @RequestBody @Valid EstadoUpdateForm estadoUpdateForm){
        var optionalEstado = service.findByID(id);

        if (optionalEstado.isPresent()){
            return ResponseEntity.ok(service.updateEstado(id, estadoUpdateForm));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta uma Estado")
    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Long id){
        var optionalEstado = service.findByID(id);
        if (optionalEstado.isPresent()){
            service.delete(optionalEstado.get());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
