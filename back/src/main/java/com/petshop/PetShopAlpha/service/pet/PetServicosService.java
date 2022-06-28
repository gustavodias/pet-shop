package com.petshop.PetShopAlpha.service.pet;

import com.petshop.PetShopAlpha.controller.dto.pet.PetServicosDTO;
import com.petshop.PetShopAlpha.controller.form.pet.PetServicosForm;
import com.petshop.PetShopAlpha.repository.pet.PetServicosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PetServicosService {

    private final PetServicosRepository repository;
    private final ServicosService servicosService;
    private final PetService petService;

    public List<PetServicosDTO> findAll(){
        var list = repository.findAll();
        return list.stream().map(PetServicosDTO::new).collect(Collectors.toList());
    }

    public PetServicosDTO save(PetServicosForm form){
        var servicos = servicosService.findById(form.getIdServicos());
        var pet = petService.findById(form.getIdPet());

        var petServico = repository.save(form.converter(pet.get(), servicos.get()));
        return new PetServicosDTO(petServico);
    }
}
