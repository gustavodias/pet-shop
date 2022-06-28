package com.petshop.PetShopAlpha.repository.funcionario;

import com.petshop.PetShopAlpha.model.funcionario.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
    Optional<Cargo> findByNome(String nome);
}
