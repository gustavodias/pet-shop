package com.petshop.PetShopAlpha.controller.form.usuario;

import com.petshop.PetShopAlpha.controller.form.endereco.create.BairroForm;
import com.petshop.PetShopAlpha.controller.form.endereco.create.CidadeForm;
import com.petshop.PetShopAlpha.controller.form.endereco.create.EstadoForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioAllForm {
    private EstadoForm estado;
    private CidadeForm cidade;
    private BairroForm bairro;
    private UsuarioForm usuario;

    public UsuarioAllForm(EstadoForm estado, CidadeForm cidade, BairroForm bairro, UsuarioForm usuario) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.usuario = usuario;
    }
}
