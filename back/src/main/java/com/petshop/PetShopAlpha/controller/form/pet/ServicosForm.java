package com.petshop.PetShopAlpha.controller.form.pet;

import com.petshop.PetShopAlpha.model.pet.Servicos;
import com.petshop.PetShopAlpha.model.produto.Produto;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class ServicosForm {
    @NotBlank
    private String tipo;
    @NotNull
    private BigDecimal valor;

    public Servicos converter(){
        return new Servicos(tipo,valor);
    }
}
