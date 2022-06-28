package com.petshop.PetShopAlpha.controller.form.funcionario;

import com.petshop.PetShopAlpha.model.Usuario;
import com.petshop.PetShopAlpha.model.funcionario.Cargo;
import com.petshop.PetShopAlpha.model.funcionario.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioForm {
    @Email
    private String email;
    @NotNull
    @NotEmpty
    private String senha;

    public Funcionario converter(Cargo cargo, Usuario usuario) {
        return new Funcionario(email,senha,cargo,usuario);
    }
}
