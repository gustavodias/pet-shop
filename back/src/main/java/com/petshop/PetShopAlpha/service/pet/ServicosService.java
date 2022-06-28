package com.petshop.PetShopAlpha.service.pet;

import com.petshop.PetShopAlpha.controller.dto.pet.PetDTO;
import com.petshop.PetShopAlpha.controller.dto.pet.ServicosDTO;
import com.petshop.PetShopAlpha.controller.form.pet.PetForm;
import com.petshop.PetShopAlpha.controller.form.pet.ServicosForm;
import com.petshop.PetShopAlpha.model.pet.Pet;
import com.petshop.PetShopAlpha.model.pet.Servicos;
import com.petshop.PetShopAlpha.repository.pet.ServicosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ServicosService {

    private final ServicosRepository repository;

    public List<ServicosDTO> findAll(){
        var list = repository.findAll();
        return list.stream().map(ServicosDTO::new).collect(Collectors.toList());
    }

    public Optional<Servicos> findById(Long id){
        return repository.findById(id);
    }

    public Servicos saveProduto(ServicosForm form){
        return repository.save(form.converter());
    }
}
