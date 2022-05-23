import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClienteService } from '../../../../services/cliente.service';
import { Cliente } from '../../../../models/cliente';
import { FormControl, Validators } from '@angular/forms';
import { CLienteFull } from '../../../../models/clientefull';
import { Endereco } from '../../../../models/endereco';
import { Contato } from '../../../../models/contato';

@Component({
  selector: 'app-cliente-create',
  templateUrl: './cliente-create.component.html',
  styleUrls: ['./cliente-create.component.css']
})
export class ClienteCreateComponent implements OnInit { 

  endereco: Endereco = {
    id: '',
    rua: '',
    numero: '',
    bairro: '',
    cep: '',
    cidade: '',
    uf: '',
    complemento: ''
  }

  cliente: Cliente = {
    id: '',
    nome: '',
    cpf: '',
    senha: '',
    dataNascimento: ''
}

  contato: Contato = {
  id: '',
  telefone: '',
  idCliente: 0
}

clienteFull: CLienteFull = {
  endereco: this.endereco,
  cliente:  this.cliente,
  contato: this.contato
}

rua = new FormControl('', [Validators.minLength(3)])
numero = new FormControl('', [Validators.minLength(3)])
bairro = new FormControl('', [Validators.minLength(3)])
cep = new FormControl('', [Validators.minLength(3)])
cidade = new FormControl('', [Validators.minLength(3)])
uf = new FormControl('', [Validators.minLength(2)])
complemento = new FormControl('', [Validators.minLength(3)])

nome = new FormControl('', [Validators.minLength(3)])
cpf = new FormControl('', [Validators.minLength(11)])
senha = new FormControl('', [Validators.minLength(8)])
dataNascimento = new FormControl('', [Validators.minLength(8)])

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
      this.router.navigate(['login'])
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
    this.router.navigate(['login'])
  }

}
