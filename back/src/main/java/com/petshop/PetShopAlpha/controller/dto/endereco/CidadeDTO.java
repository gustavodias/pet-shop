package com.petshop.PetShopAlpha.controller.dto.endereco;

import com.petshop.PetShopAlpha.model.endereco.Cidade;
import com.petshop.PetShopAlpha.model.endereco.Estado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeDTO {

    private Long id;
    private String nome;
    private Estado estado;

    public CidadeDTO(Cidade cidade) {
        this.id = cidade.getId();
        this.nome = cidade.getNome();
        this.estado = cidade.getEstado();
    }
}
