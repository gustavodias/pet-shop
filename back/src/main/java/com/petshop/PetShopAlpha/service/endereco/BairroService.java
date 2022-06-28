package com.petshop.PetShopAlpha.service.endereco;

import com.petshop.PetShopAlpha.controller.dto.endereco.BairroDTO;
import com.petshop.PetShopAlpha.controller.form.endereco.create.BairroForm;
import com.petshop.PetShopAlpha.controller.form.endereco.update.BairroUpdateForm;
import com.petshop.PetShopAlpha.model.endereco.Bairro;
import com.petshop.PetShopAlpha.model.endereco.Cidade;
import com.petshop.PetShopAlpha.repository.endereco.BairroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BairroService {

    private final BairroRepository repository;

    public Optional<Bairro> findByNomeBairro(String nome){
        return repository.findByNome(nome);
    }

    public List<BairroDTO> findAll(){
        var bairro = repository.findAll();
        return bairro.stream().map(BairroDTO::new).collect(Collectors.toList());
    }

    public Optional<Bairro> findByIdBairro(Long id){
        return repository.findById(id);
    }

    public BairroDTO save(BairroForm form){
        var opBairro=findByNomeBairro(form.getNome());
        var cidade = opBairro.get().getCidade();
        if (findByNomeBairro(form.getNome()).isPresent()){
            return new BairroDTO(opBairro.get());
        }else {
            var bairro = repository.save(form.converter(cidade));
            return new BairroDTO(bairro);
        }
    }

    @Transactional
    public BairroDTO updateBairro(Long id, BairroUpdateForm form){
        var dados = form.atualizarDados(repository.findById(id).get());
        return new BairroDTO(dados);
    }

    public void delete(Bairro bairro){
        repository.delete(bairro);
    }

}
