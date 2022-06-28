package com.petshop.PetShopAlpha.controller.dto.funcionario;

import com.petshop.PetShopAlpha.model.funcionario.Funcionario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDTO {
    private Long id;
    private String email;
    private String cargo;
    private String nome;

    public FuncionarioDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.email = funcionario.getEmail();
        this.cargo = funcionario.getCargo().getNome();
        this.nome = funcionario.getUsuario().getNome();
    }
}
