package com.petshop.PetShopAlpha.service;

import com.petshop.PetShopAlpha.model.cliente.Cliente;
import com.petshop.PetShopAlpha.model.Usuario;
import com.petshop.PetShopAlpha.model.embeddable.ItensPedidoCompraPK;
import com.petshop.PetShopAlpha.model.embeddable.PetServicosPK;
import com.petshop.PetShopAlpha.model.endereco.Bairro;
import com.petshop.PetShopAlpha.model.endereco.Cidade;
import com.petshop.PetShopAlpha.model.endereco.Estado;
import com.petshop.PetShopAlpha.model.funcionario.Cargo;
import com.petshop.PetShopAlpha.model.funcionario.Funcionario;
import com.petshop.PetShopAlpha.model.pet.Pet;
import com.petshop.PetShopAlpha.model.pet.PetServicos;
import com.petshop.PetShopAlpha.model.pet.Servicos;
import com.petshop.PetShopAlpha.model.produto.ItensPedidoCompra;
import com.petshop.PetShopAlpha.model.produto.PedidoCompra;
import com.petshop.PetShopAlpha.model.produto.Produto;
import com.petshop.PetShopAlpha.repository.*;
import com.petshop.PetShopAlpha.repository.endereco.BairroRepository;
import com.petshop.PetShopAlpha.repository.endereco.CidadeRepository;
import com.petshop.PetShopAlpha.repository.endereco.EstadoRepository;
import com.petshop.PetShopAlpha.repository.funcionario.CargoRepository;
import com.petshop.PetShopAlpha.repository.funcionario.FuncionarioRepository;
import com.petshop.PetShopAlpha.repository.pet.PetRepository;
import com.petshop.PetShopAlpha.repository.pet.PetServicosRepository;
import com.petshop.PetShopAlpha.repository.pet.ServicosRepository;
import com.petshop.PetShopAlpha.repository.produto.ItensPedidoCompraRepository;
import com.petshop.PetShopAlpha.repository.produto.PedidoCompraRepository;
import com.petshop.PetShopAlpha.repository.produto.ProdutoRepository;
import com.petshop.PetShopAlpha.service.endereco.BairroService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Service
@AllArgsConstructor
public class DBService {

    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final TelefoneRepository telefoneRepository;
    private final CidadeRepository cidadeRepository;
    private final EstadoRepository estadoRepository;
    private final BairroRepository bairroRepository;

    private final PasswordEncoder encoder;

    private final CargoRepository cargoRepository;

    private final UsuarioRepository usuarioRepository;

    private final ProdutoRepository produtosRepository;
    private final PedidoCompraRepository pedidoCompraRepository;
    private final ItensPedidoCompraRepository itensPedidoCompraRepository;

    private final PetRepository petRepository;
    private final ServicosRepository servicosRepository;
    private final PetServicosRepository petServicosRepository;

    private final BairroService service;


    public void instanciaBaseDeDados() throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Date datatest = sdf1.parse("23/11/2015");

        var estado = new Estado(1l, "PERNAMBUCO", "BRASIL");

        var cidade = new Cidade(1l, "RECIFE", estado);

        var bairro = new Bairro(1L, "Casa Forte", cidade);


        var cargo = new Cargo(1l, "ATENDENTE", new BigDecimal("1100.0"), "ATENDENTE");
        var cargo2 = new Cargo(2l, "GERENTE", new BigDecimal("3500.0"), "GERENTE GERAL");

        Usuario usuario = new Usuario(1L, "Douglas Do Vale", "50081084099", datatest, "Padre donino", 12, "Casa", "52061510", bairro)
                .comTelefone("81998561999");

        Usuario usuario2 = new Usuario(2L, "Eduardo Nilo", "43665990076", datatest, "Ameixa", 1234, "Casa", "52061510", bairro)
                .comTelefone("81998561792");

        var cliente = new Cliente(1L, "eduardo@gmail.com", "123456", usuario2);
        cliente.setSenha(encoder.encode(cliente.getSenha()));

        var funcionario = new Funcionario(1L,"douglas@gmail.com", "12345", cargo, usuario);
        funcionario.setSenha(encoder.encode(funcionario.getSenha()));

        Usuario usuario3 = new Usuario(3L, "Gustavo Dias", "39332228000", datatest, "Padre donino", 12, "Casa", "52061510", bairro)
                .comTelefone("81998561793");

        var funcionario2 = new Funcionario(2L,"gustavo@gmail.com", "123", cargo2, usuario3);
        funcionario2.setSenha(encoder.encode(funcionario2.getSenha()));

        var produto = new Produto(1L,"Escova",new BigDecimal("12.90"));
        var pedidoCompra = new PedidoCompra(1L, new BigDecimal("0.0"),funcionario,cliente);

        var itensPedidoCompraPK = new ItensPedidoCompraPK(produto.getId(), pedidoCompra.getId());

        var itensPedidoCompra = new ItensPedidoCompra(itensPedidoCompraPK, pedidoCompra, produto, 10);
        pedidoCompra.calcularTotalPedido(produto.getValor(), itensPedidoCompra.getQuantidade());

        var pet = new Pet(1L,"Thor",datatest, new BigDecimal("12.592"),"cachorro","Pit-bull",funcionario,cliente);
        var servico = new Servicos(1L, "Tosa", new BigDecimal("50.0"));

        var petServico = new PetServicos(new PetServicosPK(pet.getId(),servico.getId()),pet,servico,"Tosa completa");

        this.estadoRepository.save(estado);
        this.cidadeRepository.save(cidade);
        this.bairroRepository.save(bairro);

        this.usuarioRepository.saveAll(Arrays.asList(usuario, usuario2, usuario3));

        this.clienteRepository.save(cliente);

        this.cargoRepository.saveAll(Arrays.asList(cargo,cargo2));
        this.funcionarioRepository.saveAll(Arrays.asList(funcionario, funcionario2));

        this.produtosRepository.save(produto);
        this.pedidoCompraRepository.save(pedidoCompra);
        this.itensPedidoCompraRepository.save(itensPedidoCompra);

        this.petRepository.save(pet);
        this.servicosRepository.save(servico);
        this.petServicosRepository.save(petServico);
    }
}
