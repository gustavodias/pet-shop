package com.petshop.PetShopAlpha.service;

import com.petshop.PetShopAlpha.controller.dto.cliente.ClienteDTO;
import com.petshop.PetShopAlpha.controller.form.cliente.ClienteAllForm;
import com.petshop.PetShopAlpha.model.cliente.Cliente;
import com.petshop.PetShopAlpha.model.endereco.Cidade;
import com.petshop.PetShopAlpha.repository.ClienteRepository;
import com.petshop.PetShopAlpha.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final UsuarioService usuarioService;
    private final PasswordEncoder encoder;

    public List<ClienteDTO> findAll(){
        var list = repository.findAll();
        return list.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public Optional<Cliente> findById(Long id){
        return repository.findById(id);
    }

    public ClienteDTO saveCliente(ClienteAllForm form) throws ParseException {
        var usuario = usuarioService.saveUsuario(form.getUserAll());
        var cliente = form.getCliente().converter(usuario);
        cliente.setSenha(encoder.encode(cliente.getSenha()));
        repository.save(cliente);
        return new ClienteDTO(cliente);
    }
}
