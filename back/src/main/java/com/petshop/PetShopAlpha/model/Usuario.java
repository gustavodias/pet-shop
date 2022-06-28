package com.petshop.PetShopAlpha.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petshop.PetShopAlpha.model.cliente.Cliente;
import com.petshop.PetShopAlpha.model.endereco.Bairro;
import com.petshop.PetShopAlpha.model.funcionario.Funcionario;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "usuario")
@Table(name = "usuario")
@JsonIgnoreProperties
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column(unique = true)
    @CPF
    private String cpf;

    @Column
    private Date dataNascimento;

    @Column
    private String logradouro;

    @Column
    private Integer numero;

    @Column
    private String complemento;

    @Column
    private String cep;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Bairro bairro;

    @OneToMany(mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Telefone> telefones = new ArrayList<>();

    @OneToOne(mappedBy = "usuario")
    private Funcionario funcionario;

    @OneToOne(mappedBy = "usuario")
    private Cliente cliente;

    public Usuario comTelefone(String numero){
        telefones.add(new Telefone(numero, this));
        return this;
    }

    public Usuario(Long id, String nome, String cpf, Date dataNascimento, String logradouro, Integer numero, String complemento, String cep, Bairro bairro, Cliente cliente) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.cliente = cliente;
    }

    public Usuario(Long id, String nome, String cpf, Date dataNascimento, String logradouro, Integer numero, String complemento, String cep, Bairro bairro, Funcionario funcionario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.funcionario = funcionario;
    }

     public String getSenhas(){
        String senha;
         if (this.funcionario == null){
             return cliente.getSenha();
         }else {
             return funcionario.getSenha();
         }
    }

    public String getNome() {
        return nome;
    }

    public Usuario(Long id, String nome, String cpf, Date dataNascimento, String logradouro, Integer numero, String complemento, String cep, Bairro bairro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
    }

    public Usuario(String nome, String cpf, Date dataNascimento, String logradouro, Integer numero, String complemento, String cep, Bairro bairro) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
    }
}
