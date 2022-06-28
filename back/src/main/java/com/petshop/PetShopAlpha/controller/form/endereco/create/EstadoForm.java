package com.petshop.PetShopAlpha.controller.form.endereco.create;

import com.petshop.PetShopAlpha.model.endereco.Estado;
import com.petshop.PetShopAlpha.repository.endereco.EstadoRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class EstadoForm {
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String pais;

    public Estado converter(){
        return new Estado(nome, pais);
    }
}
