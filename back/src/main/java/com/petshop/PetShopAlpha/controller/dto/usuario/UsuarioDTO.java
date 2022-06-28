package com.petshop.PetShopAlpha.controller.dto.usuario;

import com.petshop.PetShopAlpha.model.Telefone;
import com.petshop.PetShopAlpha.model.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private List<String> telefones;
    private String senha;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.dataNascimento = usuario.getDataNascimento();
        this.logradouro = usuario.getLogradouro();
        this.numero = usuario.getNumero();
        this.complemento = usuario.getComplemento();
        this.cep = usuario.getCep();
        this.bairro = usuario.getBairro().getNome();
        this.cidade = usuario.getBairro().getCidade().getNome();
        this.estado = usuario.getBairro().getCidade().getEstado().getNome();
        this.pais = usuario.getBairro().getCidade().getEstado().getPais();
        this.telefones = usuario.getTelefones().stream().map(Telefone::getNumero).collect(Collectors.toList());
        if (usuario.getFuncionario() == null){
            this.senha = usuario.getCliente().getSenha();
        }else {
            this.senha = usuario.getFuncionario().getSenha();
        }
    }
}
