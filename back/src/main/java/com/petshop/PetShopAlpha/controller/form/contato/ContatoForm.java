package com.petshop.PetShopAlpha.controller.form.contato;

import com.petshop.PetShopAlpha.model.Cliente;
import com.petshop.PetShopAlpha.model.Contato;
import com.petshop.PetShopAlpha.repository.ClienteRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class ContatoForm {
    @NotNull
    @NotEmpty
    private String telefone;
    @NotNull
    private Long idCliente;

    public ContatoForm(Contato contato) {
        this.telefone = contato.getTelefone();
        this.idCliente = contato.getCliente().getId();
    }

    public Contato converter(ClienteRepository repository){
        var cliente = repository.findById(idCliente).get();
        return new Contato(telefone, cliente);
    }

    public Contato converterSemId(Cliente cliente){
        return new Contato(telefone, cliente);
    }

}
