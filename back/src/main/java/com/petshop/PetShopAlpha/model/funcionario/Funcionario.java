package com.petshop.PetShopAlpha.model.funcionario;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.petshop.PetShopAlpha.model.Usuario;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "funcionario")
@Table(name = "funcionario")
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Email
    private String email;

    @Column
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cargo cargo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    public Funcionario(String email, String senha, Cargo cargo, Usuario usuario) {
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.usuario = usuario;
    }

    public Funcionario(Long id, String email, String senha, Cargo cargo) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
    }

    public Funcionario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}
