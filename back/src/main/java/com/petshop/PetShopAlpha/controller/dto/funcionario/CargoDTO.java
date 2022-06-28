package com.petshop.PetShopAlpha.controller.dto.funcionario;

import com.petshop.PetShopAlpha.model.funcionario.Cargo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CargoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal salario;

    public CargoDTO(Cargo cargo) {
        this.id = cargo.getId();
        this.nome = cargo.getNome();
        this.descricao = cargo.getDescricao();
        this.salario = cargo.getSalario();
    }
}
