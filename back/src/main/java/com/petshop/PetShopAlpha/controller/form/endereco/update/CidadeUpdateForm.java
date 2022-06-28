package com.petshop.PetShopAlpha.controller.form.endereco.update;

import com.petshop.PetShopAlpha.model.endereco.Bairro;
import com.petshop.PetShopAlpha.model.endereco.Cidade;
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
public class CidadeUpdateForm {

    @NotNull
    @NotEmpty
    private String nome;

    public Cidade atualizarDados(Cidade cidade) {
        cidade.setNome(nome);
        return cidade;
    }
}
