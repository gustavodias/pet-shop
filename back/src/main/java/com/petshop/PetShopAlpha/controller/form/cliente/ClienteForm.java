package com.petshop.PetShopAlpha.controller.form.cliente;

import com.petshop.PetShopAlpha.model.Cliente;
import com.petshop.PetShopAlpha.model.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@NoArgsConstructor
public class ClienteForm {
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String cpf;
    @NotNull @NotEmpty
    private String senha;
    @NotNull @NotEmpty
    private String dataNascimento;

    public ClienteForm(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.senha = cliente.getSenha();
    }

    public Cliente converter(Endereco endereco) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dataNasc = formatter.parse(dataNascimento);
        return new Cliente(nome, cpf, senha, dataNasc, endereco);
    }
}
