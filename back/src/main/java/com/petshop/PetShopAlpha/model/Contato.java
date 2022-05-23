package com.petshop.PetShopAlpha.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "contato")
@Table(name = "contato")
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String telefone;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    public Contato(String telefone, Cliente cliente) {
        this.telefone = telefone;
        this.cliente = cliente;
    }
}
