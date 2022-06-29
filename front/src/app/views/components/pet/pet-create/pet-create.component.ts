import { Usuario } from './../../../../models/usuario/usuario';
import { Cliente } from 'src/app/models/cliente';
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Pet } from 'src/app/models/pet';
import { ClienteService } from 'src/app/services/cliente.service';
import { PetService } from 'src/app/services/pet.service';

@Component({
  selector: 'app-pet-create',
  templateUrl: './pet-create.component.html',
  styleUrls: ['./pet-create.component.css']
})
export class PetCreateComponent implements OnInit {

 
  pet: Pet = {
    nome: '',
    especie:  '',
    raca:  '',
    peso: '',
    dataNascimento: '',
    clienteNome:''
  }

  cliente: Cliente = {
    id: '',
    nome: '',
    email: ''
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

  clientes: Cliente[] = [];
  usuarios: Usuario[] = [];


nome = new FormControl('', [Validators.minLength(3)])
especie = new FormControl('', [Validators.minLength(3)])
raca = new FormControl('', [Validators.minLength(3)])
peso = new FormControl('', [Validators.minLength(3)])
dataNascimento = new FormControl('', [Validators.minLength(3)])
clienteNome = new FormControl('', [Validators.minLength(3)])


  constructor(
    private router : Router,
    private service: PetService,
    private serviceCliente: ClienteService
  ) { }

  ngOnInit(): void {
    this.clientes
    this.findAllCliente();
  }

  findAllCliente():void{
    this.serviceCliente.findAll().subscribe(res => {
      this.clientes = res
      console.log(this.clientes)
    })
  }

  create(): void {
    this.pet.clienteNome = this.cliente.nome
    console.log(this.pet)
    this.service.create(this.pet).subscribe((resposta) => {
      this.router.navigate(['pet/read'])
      this.service.message('Pet criado com sucesso!')
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
    this.router.navigate(['pet/read'])
  }

}
