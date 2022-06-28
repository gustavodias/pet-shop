package com.petshop.PetShopAlpha.repository;

import com.petshop.PetShopAlpha.model.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String cpf);
}
