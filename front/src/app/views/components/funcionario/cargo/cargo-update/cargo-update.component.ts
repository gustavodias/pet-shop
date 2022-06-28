import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Cargo } from 'src/app/models/funcionario/cargo';
import { CargoService } from 'src/app/services/cargo.service';

@Component({
  selector: 'app-cargo-update',
  templateUrl: './cargo-update.component.html',
  styleUrls: ['./cargo-update.component.css']
})
export class CargoUpdateComponent implements OnInit {

  id_cargo = ''

  cargo: Cargo = {
    id: '',
    nome: '',
    salario:'',
    descricao:''
  }

  nome = new FormControl('', [Validators.minLength(3)])
  descricao = new FormControl('', [Validators.minLength(11)])
  salario = new FormControl('', [Validators.minLength(3)])

  constructor(private router: Router,
              private service: CargoService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id_cargo = this.route.snapshot.paramMap.get('id')!
    this.findById();
  }

  findById(): void{
    this.service.findById(this.id_cargo).subscribe(res => {
      this.cargo = res;
      console.log(this.cargo)
      console.log(123)
    }) 
  }

  update():void{
    this.service.update(this.cargo).subscribe(res => {
      this.router.navigate(['funcionario/read'])
      this.service.message('Cargo Atualizado com Sucesso!')
    })
  }

  cancel():void{
      this.router.navigate(['funcionario/read'])
  }

}
