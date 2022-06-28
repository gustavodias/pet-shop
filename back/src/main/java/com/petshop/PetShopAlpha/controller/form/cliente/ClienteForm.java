package com.petshop.PetShopAlpha.controller.form.cliente;

import com.petshop.PetShopAlpha.model.Usuario;
import com.petshop.PetShopAlpha.model.cliente.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@NoArgsConstructor
public class ClienteForm {
    @Email
    private String email;
    @NotNull @NotEmpty
    private String senha;

    public Cliente converter(Usuario usuario){
        return new Cliente(email, senha, usuario);
    }
}
