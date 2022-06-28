package com.petshop.PetShopAlpha.repository.endereco;

import com.petshop.PetShopAlpha.model.endereco.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BairroRepository extends JpaRepository<Bairro, Long> {
    Optional<Bairro> findByNome(String nome);
}
