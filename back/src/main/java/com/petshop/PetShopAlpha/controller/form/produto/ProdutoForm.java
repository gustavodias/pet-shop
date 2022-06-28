package com.petshop.PetShopAlpha.controller.form.produto;

import com.petshop.PetShopAlpha.model.produto.Produto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class ProdutoForm {
    @NotBlank
    private String nome;
    @NotNull
    private BigDecimal valor;

    public Produto converter(){
        return new Produto(nome,valor);
    }
}
