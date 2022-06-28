import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Cargo } from 'src/app/models/funcionario/cargo';
import { Usuario } from 'src/app/models/usuario/usuario';
import { CargoService } from 'src/app/services/cargo.service';
import { FuncionarioService } from 'src/app/services/funcionario.service';
import { Funcionario } from '../../../../models/funcionario/funcionario';
import { FuncionarioUpSmart } from '../../../../models/funcionario/funcionarioUpSmart';

@Component({
  selector: 'app-funcionario-update',
  templateUrl: './funcionario-update.component.html',
  styleUrls: ['./funcionario-update.component.css']
})
export class FuncionarioUpdateComponent implements OnInit {

  id_func = '';

  carg = ''

  funcionario: Funcionario = {
    id: '',
    email:  '',
    senha:  '',
    cargo: '',
    nome: ''
}

  response = {
    id: '',
    cargo: ''}

    funcionarios: Funcionario[]=[];
    cargos: Cargo[] = [];
  
  nome = new FormControl('', [Validators.minLength(5)])
  cargoNome = new FormControl('', [Validators.minLength(3)])

  constructor(
    private router: Router,
    private service: FuncionarioService,
    private serviceCargo: CargoService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id_func = this.route.snapshot.paramMap.get('id')!
    this.findById();
    console.log(this.id_func)
    this.findAllCargo();
  }

  findAllCargo():void{
    this.serviceCargo.findAll().subscribe(res => {
      this.cargos = res
      console.log
    })
  }

  update():void {
    this.response.id = this.id_func;
    this.response.cargo = this.funcionario.cargo
    this.service.updateSmart(this.response).subscribe((resposta) => {
      this.router.navigate(['funcionario/read'])
      this.service.message('Técnico atualizado com sucesso!')
    }, err => {
      if (err.error.error.match('já cadastrado')) {
        this.service.message(err.error.error)
      } else if(err.error.errors[0].message === "número do registro de contribuinte individual brasileiro (CPF) inválido"){
        this.service.message("CPF inválido!")
      }
    })
  }
  
  findById(): void {
    this.service.findById(this.id_func).subscribe(resposta => {
      this.funcionario = resposta;
      console.log(resposta)
    })
  }

  cancel(): void {
    this.router.navigate(['funcionarios'])
  }
  
  errorValidName() {
    if(this.nome.invalid) {
      return 'O nome deve ter entre 5 e 100 caracteres!';
    }
    return false;
  }


}
