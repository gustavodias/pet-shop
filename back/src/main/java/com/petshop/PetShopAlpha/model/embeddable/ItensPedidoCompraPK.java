package com.petshop.PetShopAlpha.model.embeddable;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class ItensPedidoCompraPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pedido_compra_id")
    private Long pedidoCompraId;

    @Column(name = "produto_id")
    private Long produtoId;


}
