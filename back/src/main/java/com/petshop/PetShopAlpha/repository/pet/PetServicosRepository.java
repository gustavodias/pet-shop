package com.petshop.PetShopAlpha.repository.pet;

import com.petshop.PetShopAlpha.model.embeddable.PetServicosPK;
import com.petshop.PetShopAlpha.model.pet.PetServicos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetServicosRepository extends JpaRepository<PetServicos, PetServicosPK> {
}
