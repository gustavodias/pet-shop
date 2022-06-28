package com.petshop.PetShopAlpha.controller.form.funcionario;

import com.petshop.PetShopAlpha.model.funcionario.Cargo;
import com.petshop.PetShopAlpha.model.funcionario.Funcionario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class FuncionarioUpdateForm {
    @NotBlank
    private String cargo;

    public Funcionario atualizarDados(Funcionario funcionario, Cargo cargo) {
        funcionario.setCargo(cargo);
        return funcionario;
    }
}
