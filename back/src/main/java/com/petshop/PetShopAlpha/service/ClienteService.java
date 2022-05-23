package com.petshop.PetShopAlpha.service;

import com.petshop.PetShopAlpha.controller.form.cliente.ClienteAllParamForm;
import com.petshop.PetShopAlpha.controller.dto.cliente.ClienteFullDTO;
import com.petshop.PetShopAlpha.repository.ClienteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final EnderecoService enderecoService;
    private final ContatoService contatoService;
    private final PasswordEncoder encoder;

    public ClienteService(ClienteRepository clienteRepository, PasswordEncoder encoder, EnderecoService enderecoService, ContatoService contatoService) {
        this.clienteRepository = clienteRepository;
        this.encoder = encoder;
        this.enderecoService = enderecoService;
        this.contatoService = contatoService;
    }

    public List<ClienteFullDTO> findAll(){
        var cliente = clienteRepository.findAll();
        return cliente.stream().map(ClienteFullDTO::new).collect(Collectors.toList());
    }

    public ClienteFullDTO saveClienteAllParam(ClienteAllParamForm form) throws ParseException {
        var endereco = enderecoService.saveEndereco(form.getEndereco());
        var cliente = form.getCliente().converter(endereco);
        cliente.setSenha(encoder.encode(cliente.getSenha()));
        clienteRepository.save(cliente);
        contatoService.saveContato2(form.getContato(), cliente);
        return new ClienteFullDTO(cliente);

    }
}
