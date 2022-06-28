import { Component, OnInit } from '@angular/core';
import { Estado } from '../../../../models/endereco/estado';
import { Bairro } from '../../../../models/endereco/bairro';
import { FormControl, Validators } from '@angular/forms';
import { Cidade } from '../../../../models/endereco/cidade';
import { Funcionario } from '../../../../models/funcionario/funcionario';
import { FuncionarioService } from '../../../../services/funcionario.service';
import { Router } from '@angular/router';
import { FuncionarioFull } from '../../../../models/funcionario/funcionariofull';
import { Usuario } from 'src/app/models/usuario/usuario';
import { UserAll } from '../../../../models/usuario/userAll';
import { Cargo } from '../../../../models/funcionario/cargo';
import { CargoService } from '../../../../services/cargo.service';

@Component({
  selector: 'app-funcionario-create',
  templateUrl: './funcionario-create.component.html',
  styleUrls: ['./funcionario-create.component.css']
})
export class FuncionarioCreateComponent implements OnInit {

  estado: Estado = {
    id: '',
    nome: '',
    pais: 'BRASIL'
  }

  cidade: Cidade = {
    id: '',
    nome: ''
  }

  bairro: Bairro = {
    id: '',
    nome: ''
  }

  usuario: Usuario ={
        id: '',
        nome: '',
        cpf:  '',
        dataNascimento: '',
        logradouro:  '',
        numero: '',
        complemento:  '',
        cep:  '',
        telefone:  ''
  }

  userAll: UserAll = {
    estado: this.estado,
    cidade: this.cidade,
    bairro: this.bairro,
    usuario: this.usuario
  }


  cargo: Cargo = {
    nome: '',
    salario:  '',
    descricao:  ''
  }

  funcionario: Funcionario = {
        id: '',
        email:  '',
        senha:  ''
  }

  funcionarioFull: FuncionarioFull = {
    userAll: this.userAll,
    cargo: this.cargo,
    funcionario: this.funcionario
  }

  cargos: Cargo[] = [];


pais = new FormControl('', [Validators.minLength(3)])
estadoNome = new FormControl('', [Validators.minLength(3)])

cidadeNome = new FormControl('', [Validators.minLength(3)])

bairroNome = new FormControl('', [Validators.minLength(3)])

nome = new FormControl('', [Validators.minLength(3)])
cpf = new FormControl('', [Validators.minLength(11)])
logradouro = new FormControl('', [Validators.minLength(3)])
numero = new FormControl('', [Validators.minLength(3)])
cep = new FormControl('', [Validators.minLength(3)])
complemento = new FormControl('', [Validators.minLength(3)])

cargoNome = new FormControl('', [Validators.minLength(3)])
salario = new FormControl('', [Validators.minLength(3)])
descricao = new FormControl('', [Validators.minLength(3)])

dataNascimento = new FormControl('', [Validators.minLength(8)])

email = new FormControl('', [Validators.minLength(3)])
senha = new FormControl('', [Validators.minLength(8)])

telefone = new FormControl('', [Validators.minLength(11)])

  constructor(
    private router : Router,
    private service: FuncionarioService,
    private serviceCargo: CargoService
  ) { }

  ngOnInit(): void {
    this.findAllCargo();
  }

  findAllCargo():void{
    this.serviceCargo.findAll().subscribe(res => {
      this.cargos = res
      console.log
    })
  }

  create(): void {
    console.log(this.funcionarioFull)
    this.service.create(this.funcionarioFull).subscribe((resposta) => {
      this.router.navigate(['funcionario/read'])
      this.service.message('Funcionario criado com sucesso!')
    }, err => {
      console.log(err)
      if (err.error.error.match('já cadastrado')) {
        this.service.message(err.error.error)
      } else if(err.error.errors[0].message === "número do registro de contribuinte individual brasileiro (CPF) inválido"){
        this.service.message("CPF inválido!")
      }
    })
  }

  cancel(): void {
    this.router.navigate([''])
  }
}
