package com.petshop.PetShopAlpha.model.pet;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Entity(name = "servicos")
@Table(name = "servicos")
public class Servicos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "servico_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tipo;

    @Column
    private BigDecimal valor;

    public Servicos(String tipo, BigDecimal valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
}
