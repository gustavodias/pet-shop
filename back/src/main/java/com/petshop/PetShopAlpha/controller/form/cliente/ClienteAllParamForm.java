package com.petshop.PetShopAlpha.controller.form.cliente;

import com.petshop.PetShopAlpha.controller.form.contato.ContatoForm;
import com.petshop.PetShopAlpha.controller.form.endereco.EnderecoForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteAllParamForm {
    private EnderecoForm endereco;
    private ClienteForm cliente;
    private ContatoForm contato;

    public ClienteAllParamForm(EnderecoForm endereco, ClienteForm cliente, ContatoForm contato) {
        this.endereco = endereco;
        this.cliente = cliente;
        this.contato = contato;
    }
}
