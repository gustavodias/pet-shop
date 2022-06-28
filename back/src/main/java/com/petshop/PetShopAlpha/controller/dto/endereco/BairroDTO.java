package com.petshop.PetShopAlpha.controller.dto.endereco;

import com.petshop.PetShopAlpha.model.endereco.Bairro;
import com.petshop.PetShopAlpha.model.endereco.Cidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BairroDTO {

    private Long id;
    private String nome;
    private Cidade cidade;

    public BairroDTO(Bairro bairro) {
        this.id = bairro.getId();
        this.nome = bairro.getNome();
        this.cidade = bairro.getCidade();
    }
}
