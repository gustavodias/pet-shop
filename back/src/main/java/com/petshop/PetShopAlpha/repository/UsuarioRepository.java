package com.petshop.PetShopAlpha.repository;

import com.petshop.PetShopAlpha.model.Usuario;
import com.petshop.PetShopAlpha.model.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCpf(String cpf);
}
