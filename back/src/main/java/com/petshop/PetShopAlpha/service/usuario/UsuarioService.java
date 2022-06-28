package com.petshop.PetShopAlpha.service.usuario;

import com.petshop.PetShopAlpha.controller.dto.usuario.UsuarioDTO;
import com.petshop.PetShopAlpha.controller.form.usuario.UsuarioAllForm;
import com.petshop.PetShopAlpha.model.Usuario;
import com.petshop.PetShopAlpha.repository.UsuarioRepository;
import com.petshop.PetShopAlpha.repository.endereco.BairroRepository;
import com.petshop.PetShopAlpha.repository.endereco.CidadeRepository;
import com.petshop.PetShopAlpha.repository.endereco.EstadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BairroRepository bairroRepository;
    private final CidadeRepository cidadeRepository;
    private final EstadoRepository estadoRepository;

    public List<UsuarioDTO> findAll(){
        var usuario = usuarioRepository.findAll();
        return usuario.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public Usuario saveUsuario(UsuarioAllForm form) throws ParseException {
        var estado = estadoRepository.save(form.getEstado().converter());
        var cidade = cidadeRepository.save(form.getCidade().converter(estado));
        var bairro = bairroRepository.save(form.getBairro().converter(cidade));
        return usuarioRepository.save(form.getUsuario().converter(bairro));
    }
}
