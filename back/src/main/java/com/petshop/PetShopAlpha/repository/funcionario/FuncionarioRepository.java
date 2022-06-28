package com.petshop.PetShopAlpha.repository.funcionario;

import com.petshop.PetShopAlpha.model.funcionario.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
