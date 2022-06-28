package com.petshop.PetShopAlpha.controller.form.usuario;

import com.petshop.PetShopAlpha.model.Usuario;
import com.petshop.PetShopAlpha.model.endereco.Bairro;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Getter
@NoArgsConstructor
public class UsuarioForm {
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

    public Usuario converter(Bairro bairro) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        var dataFormatada =  formatter.parse(dataNascimento);
        return new Usuario(nome,
                cpf,
                dataFormatada,
                logradouro,
                numero,
                complemento,
                cep,
                bairro).comTelefone(telefone);
    }
}
