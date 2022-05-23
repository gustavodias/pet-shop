package com.petshop.PetShopAlpha.controller.form.contato;

import com.petshop.PetShopAlpha.model.Contato;
import com.petshop.PetShopAlpha.repository.ClienteRepository;
import com.petshop.PetShopAlpha.repository.ContatoRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ContatoUpdateForm {
    @NotNull
    @NotEmpty
    private String telefone;
    @NotNull
    private Long idCliente;

    public ContatoUpdateForm(Contato contato) {
        this.telefone = contato.getTelefone();
        this.idCliente = contato.getCliente().getId();
    }

    public Contato atualizarDados(Long id, ContatoRepository repository, ClienteRepository clienteRepository){
        var contato = repository.findById(id);
        var cliente = clienteRepository.findById(idCliente);
        contato.get().setTelefone(this.telefone);
        contato.get().setCliente(cliente.get());
        return contato.get();
    }
}
