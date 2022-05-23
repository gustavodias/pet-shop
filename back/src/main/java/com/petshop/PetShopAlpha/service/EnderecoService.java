package com.petshop.PetShopAlpha.service;

import com.petshop.PetShopAlpha.controller.dto.EnderecoDTO;
import com.petshop.PetShopAlpha.controller.form.endereco.EnderecoForm;
import com.petshop.PetShopAlpha.controller.form.endereco.EnderecoUpdateForm;
import com.petshop.PetShopAlpha.model.Endereco;
import com.petshop.PetShopAlpha.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<EnderecoDTO> findAllEndereco(){
        var endereco = enderecoRepository.findAll();
        return endereco.stream().map(EnderecoDTO::new).collect(Collectors.toList());
    }

    public Optional<Endereco> findByIdEndereco(Long id){
        return enderecoRepository.findById(id);
    }

    public EnderecoDTO saveEnderecoDTO(EnderecoForm form){
        var endereco = form.converter();
        enderecoRepository.save(endereco);
        return new EnderecoDTO(endereco);
    }

    public Endereco saveEndereco(EnderecoForm form){
        var endereco = form.converter();
        enderecoRepository.save(endereco);
        return new Endereco(endereco.getId(), endereco.getRua(), endereco.getNumero(),endereco.getBairro(), endereco.getCep(), endereco.getCidade(), endereco.getUf(), endereco.getComplemento());
    }

    @Transactional
    public EnderecoDTO updateEndereco(Long id, EnderecoUpdateForm form){
        var endereco = form.atualizarDados(id, enderecoRepository);
        return new EnderecoDTO(endereco);
    }

    public void deleteEndereco(Endereco endereco){
        enderecoRepository.delete(endereco);
    }

}
