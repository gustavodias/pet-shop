package com.petshop.PetShopAlpha.controller.form.endereco;

import com.petshop.PetShopAlpha.model.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class EnderecoForm {

    @NotNull @NotEmpty
    private String rua;
    @NotNull
    private Integer numero;
    @NotNull @NotEmpty
    private String bairro;
    @NotNull @NotEmpty
    private String cep;
    @NotNull @NotEmpty
    private String cidade;
    @NotNull @NotEmpty
    private String uf;
    @NotNull @NotEmpty
    private String complemento;

    public EnderecoForm(Endereco endereco) {
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.bairro = endereco.getBairro();
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.uf = endereco.getUf();
        this.complemento = endereco.getComplemento();
    }

    public Endereco converter(){
        return new Endereco(rua,numero,bairro,cep,cidade,uf,complemento);
    }
}
