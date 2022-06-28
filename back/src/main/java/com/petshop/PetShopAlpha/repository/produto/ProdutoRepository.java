package com.petshop.PetShopAlpha.repository.produto;

import com.petshop.PetShopAlpha.model.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
