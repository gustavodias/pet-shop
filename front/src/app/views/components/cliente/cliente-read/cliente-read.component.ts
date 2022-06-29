import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-cliente-read',
  templateUrl: './cliente-read.component.html',
  styleUrls: ['./cliente-read.component.css']
})
export class ClienteReadComponent implements AfterViewInit {

  clientes: Cliente[] = [];


  displayedColumnsCliente: string[] = ['id', 'email', 'nome', 'action'];
  dataSourceCliente = new MatTableDataSource<Cliente>(this.clientes);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private service : ClienteService,
    private router : Router) {}

  ngAfterViewInit() {
    this.findAll();
  }

  findAll():void {
    this.service.findAll().subscribe((resposta) => {
      this.clientes = resposta;
      this.dataSourceCliente = new MatTableDataSource<Cliente>(this.clientes);
      this.dataSourceCliente.paginator = this.paginator;
    })
  }

  navigateToCreate():void {
    this.router.navigate(['cliente/cadastro'])
  }

  navigateToCreateCliente():void {
    this.router.navigate(['cliente/cadastro'])
  }

}
