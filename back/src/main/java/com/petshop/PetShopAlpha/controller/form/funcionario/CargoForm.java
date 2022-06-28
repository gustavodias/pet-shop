package com.petshop.PetShopAlpha.controller.form.funcionario;

import com.petshop.PetShopAlpha.model.funcionario.Cargo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class CargoForm {
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    private BigDecimal salario;
    @NotNull
    private String descricao;

    public Cargo converter(){
        return new Cargo(nome, salario, descricao);
    }
}
