import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Pedido } from 'src/app/models/pedido';
import { PedidoService } from 'src/app/services/pedido.service';

@Component({
  selector: 'app-pedido-read',
  templateUrl: './pedido-read.component.html',
  styleUrls: ['./pedido-read.component.css']
})
export class PedidoReadComponent implements AfterViewInit {

  pedidos: Pedido[] = [];


  displayedColumnsPedido: string[] = ['idPedido', 'idProduto', 'produto','quantidade','valorUnitario', 'total','cliente','action'];
  dataSourcePedido = new MatTableDataSource<Pedido>(this.pedidos);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private service : PedidoService,
    private router : Router) {}

  ngAfterViewInit() {
    console.log("teste")
    this.findAll();
    console.log("resposta")
  }

  findAll():void {
    this.service.findAll().subscribe((resposta) => {
      console.log(resposta)
      this.pedidos = resposta;
      this.dataSourcePedido = new MatTableDataSource<Pedido>(this.pedidos);
      this.dataSourcePedido.paginator = this.paginator;
    })
  }

  navigateToCreatePedido():void {
    this.router.navigate(['pedido/cadastro'])
  }

}
