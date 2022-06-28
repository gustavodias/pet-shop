package com.petshop.PetShopAlpha.model.funcionario;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cargo")
@Table(name = "cargo")
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private BigDecimal salario;
    @Column
    private String descricao;

    public Cargo(String nome, BigDecimal salario, String descricao) {
        this.nome = nome;
        this.salario = salario;
        this.descricao = descricao;
    }
}
