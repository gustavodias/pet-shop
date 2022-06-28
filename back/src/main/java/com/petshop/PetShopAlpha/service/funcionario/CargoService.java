package com.petshop.PetShopAlpha.service.funcionario;

import com.petshop.PetShopAlpha.controller.dto.endereco.CidadeDTO;
import com.petshop.PetShopAlpha.controller.dto.funcionario.CargoDTO;
import com.petshop.PetShopAlpha.controller.form.funcionario.CargoForm;
import com.petshop.PetShopAlpha.controller.form.funcionario.CargoUpdateForm;
import com.petshop.PetShopAlpha.model.funcionario.Cargo;
import com.petshop.PetShopAlpha.repository.funcionario.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CargoService {

    private final CargoRepository cargoRepository;

    public List<CargoDTO> findAll(){
        var cargo = cargoRepository.findAll();
        return cargo.stream().map(CargoDTO::new).collect(Collectors.toList());
    }  

    public Optional<Cargo> findByNomeCargo(String nome){
        return cargoRepository.findByNome(nome);
    }

    public Optional<Cargo> findByIdCargo(Long id){
        return cargoRepository.findById(id);
    }

    public CargoDTO saveDTO(CargoForm form){
        var cargo = cargoRepository.save(form.converter());
        return new CargoDTO(cargo);
    }

    public Cargo saveCargo(CargoForm form){
        var optional= findByNomeCargo(form.getNome());
        if (optional.isPresent()){
            return optional.get();
        }else {
            return cargoRepository.save(form.converter());
        }
    }

    @Transactional
    public CargoDTO update(Long id, CargoUpdateForm form){
            var cargo = findByIdCargo(id);
            cargo.ifPresent(form::atualizarDados);
            return new CargoDTO(cargo.get());
    }

    public void delete(Cargo cargo){
        cargoRepository.delete(cargo);
    }
}
