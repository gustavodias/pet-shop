package com.petshop.PetShopAlpha.controller.form.pet;

import com.petshop.PetShopAlpha.model.cliente.Cliente;
import com.petshop.PetShopAlpha.model.pet.Pet;
import com.petshop.PetShopAlpha.model.pet.Servicos;
import lombok.Getter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class PetForm {
    @NotBlank
    private String nome;
    @NotBlank
    private String dataNascimento;
    @NotNull
    private BigDecimal peso;
    @NotBlank
    private String especie;
    @NotBlank
    private String raca;
    @NotNull
    private Long idCliente;

    public Pet converter(Cliente cliente) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        var dataFormatada =  formatter.parse(dataNascimento);
        return new Pet(nome, dataFormatada, peso, especie, raca, cliente);
    }
}
