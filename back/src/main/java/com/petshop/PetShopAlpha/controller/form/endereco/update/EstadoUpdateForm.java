package com.petshop.PetShopAlpha.controller.form.endereco.update;

import com.petshop.PetShopAlpha.model.endereco.Bairro;
import com.petshop.PetShopAlpha.model.endereco.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoUpdateForm {

    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    private String pais;

    public Estado atualizarDados(Estado estado) {
        estado.setNome(nome);
        estado.setPais(pais);
        return estado;
    }
}
