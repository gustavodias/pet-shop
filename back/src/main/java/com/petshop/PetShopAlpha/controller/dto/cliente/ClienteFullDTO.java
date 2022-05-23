package com.petshop.PetShopAlpha.controller.dto.cliente;

import com.petshop.PetShopAlpha.model.Cliente;
import com.petshop.PetShopAlpha.model.Contato;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ClienteFullDTO {
    private Long idCliente;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private List<String> numeros;
    private String rua;
    private Integer numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;

    public ClienteFullDTO(Cliente cliente) {
        this.idCliente = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.numeros = cliente.getContatos().stream().map(Contato::getTelefone).collect(Collectors.toList());
        this.rua = cliente.getEndereco().getRua();
        this.numero = cliente.getEndereco().getNumero();
        this.bairro = cliente.getEndereco().getBairro();
        this.cep = cliente.getEndereco().getCep();
        this.cidade = cliente.getEndereco().getCidade();
        this.uf = cliente.getEndereco().getUf();
        this.complemento = cliente.getEndereco().getComplemento();
    }
}
