package com.petshop.PetShopAlpha.repository.pet;

import com.petshop.PetShopAlpha.model.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
