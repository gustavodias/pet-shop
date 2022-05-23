package com.petshop.PetShopAlpha.controller.form.cliente;

import com.petshop.PetShopAlpha.model.Cliente;
import com.petshop.PetShopAlpha.repository.ClienteRepository;
import com.petshop.PetShopAlpha.repository.EnderecoRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ClienteUpdateForm {
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    private String cpf;
    @NotNull
    private Date dataNascimento;
    @NotNull
    private Long idEndereco;

    public ClienteUpdateForm(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.idEndereco = cliente.getEndereco().getId();
    }

    public Cliente atualizarDados(Long id, ClienteRepository clienteRepository, EnderecoRepository enderecoRepository){
        var cliente = clienteRepository.findById(id);
        var endereco = enderecoRepository.findById(idEndereco);
        cliente.get().setNome(this.nome);
        cliente.get().setCpf(this.cpf);
        cliente.get().setDataNascimento(this.dataNascimento);
        cliente.get().setEndereco(endereco.get());
        return cliente.get();
    }
}
