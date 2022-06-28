package com.petshop.PetShopAlpha.controller.dto.pet;

import com.petshop.PetShopAlpha.model.pet.PetServicos;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetServicosDTO {
    private Long idPet;
    private Long idServico;
    private String descricao;

    public PetServicosDTO(PetServicos petServicos) {
        this.idPet = petServicos.getPet().getId();
        this.idServico = petServicos.getServicos().getId();
        this.descricao = petServicos.getDescricao();
    }
}
