import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClienteService } from '../../../../services/cliente.service';
import { Cliente } from '../../../../models/cliente';
import { FormControl, Validators } from '@angular/forms';
import { ClienteFull} from '../../../../models/clientefull';
import { UserAll } from 'src/app/models/usuario/userAll';
import { Bairro } from 'src/app/models/endereco/bairro';
import { Cidade } from 'src/app/models/endereco/cidade';
import { Estado } from 'src/app/models/endereco/estado';
import { Usuario } from 'src/app/models/usuario/usuario';

@Component({
  selector: 'app-cliente-create',
  templateUrl: './cliente-create.component.html',
  styleUrls: ['./cliente-create.component.css']
})
export class ClienteCreateComponent implements OnInit {

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

  cliente: Cliente = {
    id: '',
    email: '',
    senha: ''
  }

  clienteFull: ClienteFull = {
    userAll: this.userAll,
    cliente: this.cliente
  }


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

dataNascimento = new FormControl('', [Validators.minLength(8)])

email = new FormControl('', [Validators.minLength(3)])
senha = new FormControl('', [Validators.minLength(8)])

telefone = new FormControl('', [Validators.minLength(11)])

  constructor(
    private router : Router,
    private service: ClienteService
  ) { }

  ngOnInit(): void {
    
  }

  create(): void {
    console.log(this.clienteFull)
    this.service.create(this.clienteFull).subscribe((resposta) => {
      this.router.navigate(['cliente/read'])
      this.service.message('Cliente criado com sucesso!')
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
