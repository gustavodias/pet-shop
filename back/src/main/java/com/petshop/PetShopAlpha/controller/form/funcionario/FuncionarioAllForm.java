package com.petshop.PetShopAlpha.controller.form.funcionario;

import com.petshop.PetShopAlpha.controller.form.usuario.UsuarioAllForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FuncionarioAllForm {
    private UsuarioAllForm userAll;
    private CargoForm cargo;
    private FuncionarioForm funcionario;

    public FuncionarioAllForm(UsuarioAllForm userAll, CargoForm cargo, FuncionarioForm funcionario) {
        this.userAll = userAll;
        this.cargo = cargo;
        this.funcionario = funcionario;
    }
}
