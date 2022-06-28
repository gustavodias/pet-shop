import { OnInit } from '@angular/core';
import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { FuncionarioService } from 'src/app/services/funcionario.service';
import { Funcionario } from '../../../../models/funcionario/funcionario';
import { Cargo } from '../../../../models/funcionario/cargo';

@Component({
  selector: 'app-funcionario-read',
  templateUrl: './funcionario-read.component.html',
  styleUrls: ['./funcionario-read.component.css']
})
export class FuncionarioReadComponent implements AfterViewInit {

  funcionarios: Funcionario[] = [];
  cargos: Cargo[] = [];

  displayedColumns: string[] = ['id', 'nome', 'email', 'cargo', 'action'];
  dataSource = new MatTableDataSource<Funcionario>(this.funcionarios);

  displayedColumnsCargo: string[] = ['id', 'nome', 'salario', 'descricao', 'action'];
  dataSourceCargo = new MatTableDataSource<Cargo>(this.cargos);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private service : FuncionarioService,
    private router : Router) {}

  ngAfterViewInit() {
    this.findAll();
    this.findAllCargo();
  }

  findAll():void {
    this.service.findAll().subscribe((resposta) => {
      this.funcionarios = resposta;
      this.dataSource = new MatTableDataSource<Funcionario>(this.funcionarios);
      this.dataSource.paginator = this.paginator;
    })
  }

  findAllCargo():void {
    this.service.findAllCargo().subscribe((resposta) => {
      this.cargos = resposta;
      this.dataSourceCargo = new MatTableDataSource<Cargo>(this.cargos);
      this.dataSource.paginator = this.paginator;
    })
  }

  navigateToCreate():void {
    this.router.navigate(['funcionario/cadastro'])
  }

  navigateToCreateCargo():void {
    this.router.navigate(['cargo/cadastro'])
  }

}
