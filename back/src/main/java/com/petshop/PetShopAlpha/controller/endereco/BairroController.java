package com.petshop.PetShopAlpha.controller.endereco;

import com.petshop.PetShopAlpha.controller.dto.endereco.BairroDTO;
import com.petshop.PetShopAlpha.controller.form.endereco.create.BairroForm;
import com.petshop.PetShopAlpha.controller.form.endereco.update.BairroUpdateForm;
import com.petshop.PetShopAlpha.service.endereco.BairroService;
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
@RequestMapping("/api/bairro")
@CrossOrigin(origins = "*")
@Api(value = "Pet Shop - API")
@AllArgsConstructor
public class BairroController {

    private final BairroService service;

    @GetMapping
    @ApiOperation(value="Retorna uma lista de Bairros")
    public ResponseEntity<List<BairroDTO>> findAllBairros(){
        var listFunc = service.findAll();
        if (listFunc.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(listFunc);
        }
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="Retorna um Bairro com o parametro ID passado")
    public ResponseEntity<BairroDTO> findOneBairro(@PathVariable("id") Long id){
        var bairro = service.findByIdBairro(id);
        return bairro.map(value -> ResponseEntity.ok(new BairroDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/cadastro")
    @ApiOperation(value="Cria um novo Bairro")
    public ResponseEntity<BairroDTO> saveCandidato(@RequestBody @Valid BairroForm form, UriComponentsBuilder uriComponentsBuilder){
        var bairroDto = service.save(form);
        URI uri = uriComponentsBuilder.path("bairro/{id}").buildAndExpand(bairroDto.getId()).toUri();
        return ResponseEntity.created(uri).body(bairroDto);
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Atualiza uma Bairro pelo parametro ID passado")
    public ResponseEntity<BairroDTO> updateCandidato(@PathVariable("id") Long id,
                                                     @RequestBody @Valid BairroUpdateForm bairroUpdateForm){
        var optionalBairro = service.findByIdBairro(id);

        if (optionalBairro.isPresent()){
            return ResponseEntity.ok(service.updateBairro(id, bairroUpdateForm));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta uma Bairro")
    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Long id){
        var optionalBairro = service.findByIdBairro(id);
        if (optionalBairro.isPresent()){
            service.delete(optionalBairro.get());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
