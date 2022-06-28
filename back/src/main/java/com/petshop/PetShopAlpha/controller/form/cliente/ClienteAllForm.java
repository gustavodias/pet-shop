package com.petshop.PetShopAlpha.controller.form.cliente;

import com.petshop.PetShopAlpha.controller.form.usuario.UsuarioAllForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteAllForm {
    private UsuarioAllForm userAll;
    private ClienteForm cliente;

    public ClienteAllForm(UsuarioAllForm userAll, ClienteForm cliente) {
        this.userAll = userAll;
        this.cliente = cliente;
    }
}
