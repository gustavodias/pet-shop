package com.petshop.PetShopAlpha.controller.dto.pet;

import com.petshop.PetShopAlpha.model.pet.Pet;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class PetDTO {
    private Long id;
    private String nome;
    private Date dataNascimento;
    private BigDecimal peso;
    private String especie;
    private String raca;
    private String cliente;
    private String funcionario;

    public PetDTO(Pet pet) {
        this.id = pet.getId();
        this.nome = pet.getNome();
        this.dataNascimento = pet.getDataNascimento();
        this.peso = pet.getPeso();
        this.especie = pet.getEspecie();
        this.raca = pet.getRaca();
        this.cliente = pet.getCliente().getUsuario().getNome();
        this.funcionario = pet.getFuncionario().getUsuario().getNome();
    }
}
