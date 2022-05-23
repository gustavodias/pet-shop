package com.petshop.PetShopAlpha.service;

import com.petshop.PetShopAlpha.model.Cliente;
import com.petshop.PetShopAlpha.model.Contato;
import com.petshop.PetShopAlpha.model.Endereco;
import com.petshop.PetShopAlpha.repository.ClienteRepository;
import com.petshop.PetShopAlpha.repository.ContatoRepository;
import com.petshop.PetShopAlpha.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Service
public class DBService {

    private final ClienteRepository clienteRepository;
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;

    public DBService(ClienteRepository clienteRepository, ContatoRepository contatoRepository, EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.contatoRepository = contatoRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public void instanciaBaseDeDados() throws ParseException {
        var endereco1 = new Endereco("rua x",25,"Bongi", "54768-000","Recife","PE","");
        var endereco2 = new Endereco("rua y",27,"Bongi", "54768-000","Recife","PE","casa");
        var endereco3 = new Endereco("rua z",29,"Bongi", "54768-000","Recife","PE","apt");

        SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
        Date datatest = sdf1.parse("23/11/2015");

        var cliente1 = new Cliente("Gustavo Emerson", "12345678900", "12347",datatest, endereco1);
        var cliente2 = new Cliente("Eduardo", "45645678900", "8987",datatest, endereco2);
        var cliente3 = new Cliente("Douglas Do Vale", "99945678900", "8798412",datatest, endereco3);

        var contato1 = new Contato( "81978978978", cliente1);
        var contato2 = new Contato( "81978971234", cliente1);
        var contato3 = new Contato( "81978979879", cliente2);
        var contato4 = new Contato( "81995978978", cliente3);

        cliente1.getContatos().addAll(Arrays.asList(contato1,contato2));
        cliente2.getContatos().add(contato3);
        cliente3.getContatos().add(contato4);

        this.enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2,endereco3));
        this.clienteRepository.saveAll(Arrays.asList(cliente1,cliente2,cliente3));
        this.contatoRepository.saveAll(Arrays.asList(contato1,contato2,contato3,contato4));
    }
}
