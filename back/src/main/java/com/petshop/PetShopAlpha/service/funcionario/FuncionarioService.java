package com.petshop.PetShopAlpha.service.funcionario;

import com.petshop.PetShopAlpha.controller.dto.funcionario.FuncionarioDTO;
import com.petshop.PetShopAlpha.controller.form.funcionario.FuncionarioAllForm;
import com.petshop.PetShopAlpha.controller.form.funcionario.FuncionarioUpdateForm;
import com.petshop.PetShopAlpha.model.funcionario.Funcionario;
import com.petshop.PetShopAlpha.repository.funcionario.FuncionarioRepository;
import com.petshop.PetShopAlpha.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final UsuarioService usuarioService;
    private final PasswordEncoder encoder;
    private final CargoService cargoService;

    public List<FuncionarioDTO> findAll(){
        var func = funcionarioRepository.findAll();
        return func.stream().map(FuncionarioDTO::new).collect(Collectors.toList());
    }

    public Optional<Funcionario> findByIdFuncionario(Long id){
        return funcionarioRepository.findById(id);
    }

    public FuncionarioDTO saveFuncionario(FuncionarioAllForm form) throws ParseException {
        var usuario = usuarioService.saveUsuario(form.getUserAll());
        var cargo = cargoService.saveCargo(form.getCargo());
        var funcionario = form.getFuncionario().converter(cargo, usuario);
        funcionario.setSenha(encoder.encode(funcionario.getSenha()));
        funcionarioRepository.save(funcionario);
        return new FuncionarioDTO(funcionario);
    }

    @Transactional
    public FuncionarioDTO updateFuncionario(Long id, FuncionarioUpdateForm form){
        var funcionario = funcionarioRepository.findById(id);
        var cargo = cargoService.findByNomeCargo(form.getCargo());

        return new FuncionarioDTO(form.atualizarDados(funcionario.get(), cargo.get()));
    }

    public void deleteTarefa(Funcionario funcionario){
        funcionarioRepository.delete(funcionario);
    }

}
