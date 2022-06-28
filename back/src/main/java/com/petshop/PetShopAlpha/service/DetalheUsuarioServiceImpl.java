package com.petshop.PetShopAlpha.service;

import com.petshop.PetShopAlpha.data.DetalheUsuarioData;
import com.petshop.PetShopAlpha.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    public DetalheUsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        var usuario = repository.findByCpf(cpf);
        if (usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuário ["+cpf+"] não encontrado.");
        }
        return new DetalheUsuarioData(usuario);
    }
}
