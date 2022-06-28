package com.petshop.PetShopAlpha.controller.form.funcionario;

import com.petshop.PetShopAlpha.model.funcionario.Cargo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CargoUpdateForm {
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    private BigDecimal salario;
    @NotNull
    private String descricao;

    public Cargo atualizarDados(Cargo cargo) {
        cargo.setNome(this.nome);
        cargo.setSalario(this.salario);
        cargo.setDescricao(this.descricao);
        return cargo;
    }
}
