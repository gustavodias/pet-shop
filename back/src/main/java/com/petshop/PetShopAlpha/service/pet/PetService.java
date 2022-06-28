package com.petshop.PetShopAlpha.service.pet;

import com.petshop.PetShopAlpha.controller.dto.pet.PetDTO;
import com.petshop.PetShopAlpha.controller.dto.produto.ProdutoDTO;
import com.petshop.PetShopAlpha.controller.form.pet.PetForm;
import com.petshop.PetShopAlpha.controller.form.produto.ProdutoForm;
import com.petshop.PetShopAlpha.model.pet.Pet;
import com.petshop.PetShopAlpha.model.produto.Produto;
import com.petshop.PetShopAlpha.repository.pet.PetRepository;
import com.petshop.PetShopAlpha.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PetService {

    private final PetRepository repository;
    private final ClienteService clienteService;

    public List<PetDTO> findAll(){
        var list = repository.findAll();
        return list.stream().map(PetDTO::new).collect(Collectors.toList());
    }

    public Optional<Pet> findById(Long id){
        return repository.findById(id);
    }

    public Pet saveProduto(PetForm form) throws ParseException {
        var cliente = clienteService.findById(form.getIdCliente());
        return repository.save(form.converter(cliente.get()));
    }
}
