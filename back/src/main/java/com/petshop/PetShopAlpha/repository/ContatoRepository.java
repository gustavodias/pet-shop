package com.petshop.PetShopAlpha.repository;

import com.petshop.PetShopAlpha.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    List<Contato> findAllByClienteId(Long id);
}
