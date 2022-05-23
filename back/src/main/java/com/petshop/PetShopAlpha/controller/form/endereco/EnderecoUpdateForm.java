package com.petshop.PetShopAlpha.controller.form.endereco;

import com.petshop.PetShopAlpha.model.Endereco;
import com.petshop.PetShopAlpha.repository.EnderecoRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class EnderecoUpdateForm {

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

    public EnderecoUpdateForm(Endereco endereco) {
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.bairro = endereco.getBairro();
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.uf = endereco.getUf();
        this.complemento = endereco.getComplemento();
    }

    public Endereco atualizarDados(Long id, EnderecoRepository repository){
        var endereco = repository.findById(id);
        endereco.get().setRua(this.rua);
        endereco.get().setNumero(this.numero);
        endereco.get().setBairro(this.bairro);
        endereco.get().setCep(this.cep);
        endereco.get().setCidade(this.cidade);
        endereco.get().setUf(this.uf);
        endereco.get().setComplemento(this.complemento);
        return endereco.get();
    }

}
