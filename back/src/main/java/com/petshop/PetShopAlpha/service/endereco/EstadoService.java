package com.petshop.PetShopAlpha.service.endereco;

import com.petshop.PetShopAlpha.controller.dto.endereco.CidadeDTO;
import com.petshop.PetShopAlpha.controller.dto.endereco.EstadoDTO;
import com.petshop.PetShopAlpha.controller.form.endereco.create.EstadoForm;
import com.petshop.PetShopAlpha.controller.form.endereco.update.EstadoUpdateForm;
import com.petshop.PetShopAlpha.model.endereco.Estado;
import com.petshop.PetShopAlpha.repository.endereco.EstadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EstadoService {

    private final EstadoRepository repository;

    public List<EstadoDTO> findAll(){
        var estado = repository.findAll();
        return estado.stream().map(EstadoDTO::new).collect(Collectors.toList());
    }

    public Optional<Estado> findByNomeEstadoAndPais(String nome, String pais){
        return repository.findByNomeAndPais(nome, pais);
    }

    public Optional<Estado> findByID(Long id){
        return repository.findById(id);
    }

    public EstadoDTO save(EstadoForm form){
        var opEstado=findByNomeEstadoAndPais(form.getNome(), form.getPais());
        if (opEstado.isPresent()){
            return new EstadoDTO(opEstado.get());
        }else {
            var estado = repository.save(form.converter());
            return new EstadoDTO(estado);
        }
    }

    @Transactional
    public EstadoDTO updateEstado(Long id, EstadoUpdateForm form){
        var dados = form.atualizarDados(repository.findById(id).get());
        return new EstadoDTO(dados);
    }

    public void delete(Estado estado){
        repository.delete(estado);
    }
}
