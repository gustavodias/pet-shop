package com.petshop.PetShopAlpha.controller;

import com.petshop.PetShopAlpha.controller.dto.usuario.UsuarioDTO;
import com.petshop.PetShopAlpha.service.usuario.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
@Api(value = "Pet Shop - API")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    @ApiOperation(value="Retorna uma lista de Usuarios")
    public ResponseEntity<List<UsuarioDTO>> findUsuarios(){
        var listUsuario = usuarioService.findAll();
        if (listUsuario.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(listUsuario);
        }
    }
}
