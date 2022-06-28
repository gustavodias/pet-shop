package com.petshop.PetShopAlpha.service.produto;

import com.petshop.PetShopAlpha.controller.dto.produto.ProdutoDTO;
import com.petshop.PetShopAlpha.controller.form.produto.ProdutoForm;
import com.petshop.PetShopAlpha.model.cliente.Cliente;
import com.petshop.PetShopAlpha.model.produto.Produto;
import com.petshop.PetShopAlpha.repository.produto.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProdutoService {

    public final ProdutoRepository repository;

    public List<ProdutoDTO> findAll(){
        var list = repository.findAll();
        return list.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    public Optional<Produto> findById(Long id){
        return repository.findById(id);
    }

    public Produto saveProduto(ProdutoForm form){
        return repository.save(form.converter());
    }
}
