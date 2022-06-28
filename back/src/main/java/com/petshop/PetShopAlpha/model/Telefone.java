package com.petshop.PetShopAlpha.model;

import com.petshop.PetShopAlpha.model.Usuario;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Entity(name = "telefone")
@Table(name = "telefone")
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String numero;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    public Telefone(String numero, Usuario usuario) {
        this.numero = numero;
        this.usuario = usuario;
    }
}
