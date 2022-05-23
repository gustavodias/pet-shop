package com.petshop.PetShopAlpha.service;

import com.petshop.PetShopAlpha.controller.dto.ContatoDTO;
import com.petshop.PetShopAlpha.controller.form.contato.ContatoForm;
import com.petshop.PetShopAlpha.controller.form.contato.ContatoUpdateForm;
import com.petshop.PetShopAlpha.controller.form.endereco.EnderecoUpdateForm;
import com.petshop.PetShopAlpha.model.Cliente;
import com.petshop.PetShopAlpha.model.Contato;
import com.petshop.PetShopAlpha.model.Endereco;
import com.petshop.PetShopAlpha.repository.ClienteRepository;
import com.petshop.PetShopAlpha.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final ClienteRepository clienteRepository;

    public ContatoService(ContatoRepository contatoRepository, ClienteRepository clienteRepository) {
        this.contatoRepository = contatoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<ContatoDTO> findContatoByIdCliente(Long id){
        var contato = contatoRepository.findAllByClienteId(id);
        return contato.stream().map(ContatoDTO::new).collect(Collectors.toList());
    }

    public Optional<Contato> findByIdContato(Long id){
        return contatoRepository.findById(id);
    }

    public ContatoDTO saveContato(ContatoForm form){
        var contato = form.converter(clienteRepository);
        contatoRepository.save(contato);
        return new ContatoDTO(contato);
    }

    public ContatoDTO saveContato2(ContatoForm form, Cliente cliente){
        var contato = form.converterSemId(cliente);
        contatoRepository.save(contato);
        return new ContatoDTO(contato);
    }

    @Transactional
    public ContatoDTO updateContato(Long id, ContatoUpdateForm form){
        var contato = form.atualizarDados(id,contatoRepository,clienteRepository);
        return new ContatoDTO(contato);
    }

    public void deleteContato(Contato contato){ contatoRepository.delete(contato);}

}
