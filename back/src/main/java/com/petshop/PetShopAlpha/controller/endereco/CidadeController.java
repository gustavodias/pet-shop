package com.petshop.PetShopAlpha.controller.endereco;

import com.petshop.PetShopAlpha.controller.dto.endereco.CidadeDTO;
import com.petshop.PetShopAlpha.controller.form.endereco.create.CidadeForm;
import com.petshop.PetShopAlpha.controller.form.endereco.update.CidadeUpdateForm;
import com.petshop.PetShopAlpha.service.endereco.CidadeService;
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
@RequestMapping("/api/cidade")
@CrossOrigin(origins = "*")
@Api(value = "Pet Shop - API")
@AllArgsConstructor
public class CidadeController {

    private final CidadeService service;

    @GetMapping
    @ApiOperation(value="Retorna uma lista de Funcionarios")
    public ResponseEntity<List<CidadeDTO>> findAllCidades(){
        var listFunc = service.findAll();
        if (listFunc.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(listFunc);
        }
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="Retorna um Cidade com o parametro ID passado")
    public ResponseEntity<CidadeDTO> findOneCidade(@PathVariable("id") Long id){
        var cidade = service.findByIdCidade(id);
        return cidade.map(value -> ResponseEntity.ok(new CidadeDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/cadastro")
    @ApiOperation(value="Cria um novo Cidade")
    public ResponseEntity<CidadeDTO> saveCandidato(@RequestBody @Valid CidadeForm form, UriComponentsBuilder uriComponentsBuilder){
        var cidadeDto = service.save(form);
        URI uri = uriComponentsBuilder.path("cidade/{id}").buildAndExpand(cidadeDto.getId()).toUri();
        return ResponseEntity.created(uri).body(cidadeDto);
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Atualiza uma Cidade pelo parametro ID passado")
    public ResponseEntity<CidadeDTO> updateCandidato(@PathVariable("id") Long id,
                                                     @RequestBody @Valid CidadeUpdateForm cidadeUpdateForm){
        var optionalCidade = service.findByIdCidade(id);

        if (optionalCidade.isPresent()){
            return ResponseEntity.ok(service.updateCidade(id, cidadeUpdateForm));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta uma Cidade")
    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Long id){
        var optionalCidade = service.findByIdCidade(id);
        if (optionalCidade.isPresent()){
            service.delete(optionalCidade.get());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
