package com.petshop.PetShopAlpha.controller.form.endereco.create;

import com.petshop.PetShopAlpha.model.endereco.Cidade;
import com.petshop.PetShopAlpha.model.endereco.Estado;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CidadeForm {
    @NotNull @NotEmpty
    private String nome;

    public Cidade converter(Estado estado){
        return new Cidade(nome, estado);
    }
}
