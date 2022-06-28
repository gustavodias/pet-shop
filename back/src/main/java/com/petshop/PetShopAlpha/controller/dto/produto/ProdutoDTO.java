package com.petshop.PetShopAlpha.controller.dto.produto;

import com.petshop.PetShopAlpha.model.produto.Produto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoDTO {
    private Long id;
    private String nome;
    private BigDecimal valor;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
    }
}
