package com.petshop.PetShopAlpha.controller.form.endereco.create;

import com.petshop.PetShopAlpha.controller.form.usuario.UsuarioForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoForm {
    private EstadoForm estado;
    private CidadeForm cidade;
    private BairroForm bairro;
    private UsuarioForm usuario;

    public EnderecoForm(EstadoForm estado, CidadeForm cidade, BairroForm bairro, UsuarioForm usuario) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.usuario = usuario;
    }
}
