package com.petshop.PetShopAlpha.model.pet;

import com.petshop.PetShopAlpha.model.cliente.Cliente;
import com.petshop.PetShopAlpha.model.funcionario.Funcionario;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Entity(name = "pet")
@Table(name = "pet")
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pet_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private Date dataNascimento;
    @Column
    private BigDecimal peso;
    @Column
    private String especie;
    @Column
    private String raca;

    @ManyToOne(fetch = FetchType.LAZY)
    private Funcionario funcionario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    public Pet(String nome, Date dataNascimento, BigDecimal peso, String especie, String raca, Cliente cliente) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.especie = especie;
        this.raca = raca;
        this.cliente = cliente;
    }
}
