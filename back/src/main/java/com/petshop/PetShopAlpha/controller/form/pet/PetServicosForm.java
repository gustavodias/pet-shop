package com.petshop.PetShopAlpha.controller.form.pet;

import com.petshop.PetShopAlpha.model.embeddable.PetServicosPK;
import com.petshop.PetShopAlpha.model.pet.Pet;
import com.petshop.PetShopAlpha.model.pet.PetServicos;
import com.petshop.PetShopAlpha.model.pet.Servicos;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class PetServicosForm {
    @NotNull
    private Long idPet;
    @NotNull
    private Long idServicos;
    @NotBlank
    private String descricao;

    public PetServicos converter(Pet pet, Servicos servicos){
        var petServicosPK = new PetServicosPK(pet.getId(), servicos.getId());
        return new PetServicos(petServicosPK, pet, servicos, descricao);
    }
}
