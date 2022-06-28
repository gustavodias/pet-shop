package com.petshop.PetShopAlpha.controller.dto;

import com.petshop.PetShopAlpha.model.Telefone;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefoneDTO {
    private Long id;
    private String numero;
    private Long idUsuario;

    public TelefoneDTO(Telefone telefone) {
        this.id = telefone.getId();
        this.numero = telefone.getNumero();
        this.idUsuario = telefone.getUsuario().getId();
    }
}
