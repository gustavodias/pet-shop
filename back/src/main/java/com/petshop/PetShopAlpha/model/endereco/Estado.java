package com.petshop.PetShopAlpha.model.endereco;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "estado")
@Table(name = "estado")
@EqualsAndHashCode
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String pais;

    public Estado(String nome, String pais) {
        this.nome = nome;
        this.pais = pais;
    }
}
