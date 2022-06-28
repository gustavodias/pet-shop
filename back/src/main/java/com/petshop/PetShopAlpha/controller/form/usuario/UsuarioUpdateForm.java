package com.petshop.PetShopAlpha.controller.form.usuario;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UsuarioUpdateForm {
    @NotNull
    @NotEmpty
    private String nome;
    @CPF
    private String cpf;
    @NotNull
    private String dataNascimento;
    @NotNull
    @NotEmpty
    private String logradouro;
    @NotNull
    private Integer numero;
    @NotNull
    @NotEmpty
    private String complemento;
    @NotNull
    @NotEmpty
    private String cep;
    @NotNull
    @NotEmpty
    private String telefone;



}
