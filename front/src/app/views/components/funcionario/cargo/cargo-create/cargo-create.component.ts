import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Cargo } from '../../../../../models/funcionario/cargo';
import { CargoService } from '../../../../../services/cargo.service';

@Component({
  selector: 'app-cargo-create',
  templateUrl: './cargo-create.component.html',
  styleUrls: ['./cargo-create.component.css']
})
export class CargoCreateComponent implements OnInit {

 
  cargo: Cargo = {
    nome: '',
    salario:  '',
    descricao:  ''
  }



nome = new FormControl('', [Validators.minLength(3)])
descricao = new FormControl('', [Validators.minLength(11)])
salario = new FormControl('', [Validators.minLength(3)])

  constructor(
    private router : Router,
    private service: CargoService
  ) { }

  ngOnInit(): void {
  }

  create(): void {
    console.log(this.cargo)
    this.service.create(this.cargo).subscribe((resposta) => {
      this.router.navigate(['funcionario/read'])
      this.service.message('Cargo criado com sucesso!')
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
