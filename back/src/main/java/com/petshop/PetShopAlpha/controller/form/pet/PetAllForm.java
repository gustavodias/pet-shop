package com.petshop.PetShopAlpha.controller.form.pet;

import com.petshop.PetShopAlpha.controller.form.produto.ItemPedidoCompraForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PetAllForm {
    private Long idPet;
    private Long idServicos;
    private PetServicosForm petServicos;

    public PetAllForm(Long idPet, Long idServicos, PetServicosForm petServicos) {
        this.idPet = idPet;
        this.idServicos = idServicos;
        this.petServicos = petServicos;
    }
}
