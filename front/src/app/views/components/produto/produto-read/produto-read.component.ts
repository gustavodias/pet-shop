import { ViewChild } from '@angular/core';
import { AfterViewInit, Component, OnInit } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Produto } from 'src/app/models/produto';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-produto-read',
  templateUrl: './produto-read.component.html',
  styleUrls: ['./produto-read.component.css']
})
export class ProdutoReadComponent implements AfterViewInit {

  produtos: Produto[] = [];


  displayedColumnsProduto: string[] = ['id', 'nome', 'valor', 'action'];
  dataSourceProduto = new MatTableDataSource<Produto>(this.produtos);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private service : ProdutoService,
    private router : Router) {}

  ngAfterViewInit() {
    this.findAll();
  }

  findAll():void {
    this.service.findAll().subscribe((resposta) => {
      this.produtos = resposta;
      this.dataSourceProduto = new MatTableDataSource<Produto>(this.produtos);
      this.dataSourceProduto.paginator = this.paginator;
    })
  }

  navigateToCreate():void {
    this.router.navigate(['produto/cadastro'])
  }

  navigateToCreateProduto():void {
    this.router.navigate(['produto/cadastro'])
  }

}
