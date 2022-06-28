package com.petshop.PetShopAlpha.model.produto;

import com.petshop.PetShopAlpha.model.embeddable.ItensPedidoCompraPK;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "itens_pedido_compra")
@Table(name = "itens_pedido_compra")
@EqualsAndHashCode
public class ItensPedidoCompra {

    @EmbeddedId
    private ItensPedidoCompraPK pk = new ItensPedidoCompraPK();

    @ManyToOne
    @JoinColumn(name = "pedido_compra_id", referencedColumnName = "pedido_compra_id", nullable = false, updatable = false, insertable = false)
    private PedidoCompra pedidoCompra;

    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "produto_id", nullable = false, updatable = false, insertable = false)
    private Produto produto;

    @Column
    private Integer quantidade;

}
