package com.petshop.PetShopAlpha.controller.form.endereco.create;

import com.petshop.PetShopAlpha.model.endereco.Bairro;
import com.petshop.PetShopAlpha.model.endereco.Cidade;
import com.petshop.PetShopAlpha.repository.endereco.CidadeRepository;
import com.petshop.PetShopAlpha.repository.endereco.EstadoRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class BairroForm {
    @NotNull @NotEmpty
    private String nome;

    public Bairro converter(Cidade cidade){
        return new Bairro(nome, cidade);
    }
}
