package com.petshop.PetShopAlpha.controller.dto.pet;

import com.petshop.PetShopAlpha.model.pet.Servicos;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class ServicosDTO {
    private Long id;
    private String tipo;
    private BigDecimal valor;

    public ServicosDTO(Servicos servicos) {
        this.id = servicos.getId();
        this.tipo = servicos.getTipo();
        this.valor = servicos.getValor();
    }
}
