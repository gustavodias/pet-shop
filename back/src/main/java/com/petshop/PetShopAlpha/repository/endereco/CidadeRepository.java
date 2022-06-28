package com.petshop.PetShopAlpha.repository.endereco;

import com.petshop.PetShopAlpha.model.endereco.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Optional<Cidade> findByNome(String nome);

    @Query(value = "SELECT * FROM CIDADE where NOME = ?1 AND ESTADO_ID = ?2", nativeQuery = true)
    Optional<Cidade> findByNomeAndEstadoID(String nome, Long id);
}
