package com.petshop.PetShopAlpha.controller.dto.endereco;

import com.petshop.PetShopAlpha.model.endereco.Estado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoDTO {

    private Long id;
    private String nome;
    private String pais;

    public EstadoDTO(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.pais = estado.getPais();
    }
}
