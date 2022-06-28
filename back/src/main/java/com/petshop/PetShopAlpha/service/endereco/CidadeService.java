package com.petshop.PetShopAlpha.service.endereco;

import com.petshop.PetShopAlpha.controller.dto.endereco.BairroDTO;
import com.petshop.PetShopAlpha.controller.dto.endereco.CidadeDTO;
import com.petshop.PetShopAlpha.controller.form.endereco.create.CidadeForm;
import com.petshop.PetShopAlpha.controller.form.endereco.update.CidadeUpdateForm;
import com.petshop.PetShopAlpha.model.endereco.Cidade;
import com.petshop.PetShopAlpha.model.endereco.Estado;
import com.petshop.PetShopAlpha.repository.endereco.CidadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class CidadeService {

    private final CidadeRepository repository;

    public List<CidadeDTO> findAll(){
        var cidade = repository.findAll();
        return cidade.stream().map(CidadeDTO::new).collect(Collectors.toList());
    }

    public Optional<Cidade> findByIdCidade(Long id){
        return repository.findById(id);
    }

    public CidadeDTO save(CidadeForm form){
        var opCidade= repository.findByNome(form.getNome());
        if (opCidade.isPresent()) {
            var optionalCidadeEstado = repository.findByNomeAndEstadoID(opCidade.get().getNome(), opCidade.get().getEstado().getId());
            if (optionalCidadeEstado.isPresent()){
                return new CidadeDTO(opCidade.get());
            }else {
                var cidade = repository.save(form.converter(opCidade.get().getEstado()));
                return new CidadeDTO(cidade);
            }
        }else {
            var cidade = repository.save(form.converter(opCidade.get().getEstado()));
            return new CidadeDTO(cidade);
        }
    }

    @Transactional
    public CidadeDTO updateCidade(Long id, CidadeUpdateForm form){
        var dados = form.atualizarDados(repository.findById(id).get());
        return new CidadeDTO(dados);
    }

    public void delete(Cidade cidade){
        repository.delete(cidade);
    }
}
