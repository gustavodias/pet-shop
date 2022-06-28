package com.petshop.PetShopAlpha.controller.dto.cliente;

import com.petshop.PetShopAlpha.model.cliente.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

    private Long id;
    private String email;
    private String nome;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.email = cliente.getEmail();
        this.nome = cliente.getUsuario().getNome();
    }
}
