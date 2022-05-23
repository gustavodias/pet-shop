package com.petshop.PetShopAlpha.controller.dto;

import com.petshop.PetShopAlpha.model.Cliente;
import com.petshop.PetShopAlpha.model.Contato;


public class ContatoDTO {

    private Long id;
    private String telefone;
    private Cliente cliente;

    public ContatoDTO(Contato contato) {
        this.id = contato.getId();
        this.telefone = contato.getTelefone();
        this.cliente = contato.getCliente();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
