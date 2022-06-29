import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Servico } from 'src/app/models/servico';
import { ServicoService } from 'src/app/services/servico.service';

@Component({
  selector: 'app-servico-read',
  templateUrl: './servico-read.component.html',
  styleUrls: ['./servico-read.component.css']
})
export class ServicoReadComponent implements AfterViewInit {

  servicos: Servico[] = [];


  displayedColumnsServico: string[] = ['id', 'tipo', 'valor', 'action'];
  dataSourceServico = new MatTableDataSource<Servico>(this.servicos);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private service : ServicoService,
    private router : Router) {}

  ngAfterViewInit() {
    this.findAll();
  }

  findAll():void {
    this.service.findAll().subscribe((resposta) => {
      this.servicos = resposta;
      this.dataSourceServico = new MatTableDataSource<Servico>(this.servicos);
      this.dataSourceServico.paginator = this.paginator;
    })
  }

  navigateToCreate():void {
    this.router.navigate(['servico/cadastro'])
  }

  navigateToCreateServico():void {
    this.router.navigate(['servico/cadastro'])
  }

}
