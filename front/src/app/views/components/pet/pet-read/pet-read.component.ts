import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Pet } from 'src/app/models/pet';
import { PetService } from 'src/app/services/pet.service';

@Component({
  selector: 'app-pet-read',
  templateUrl: './pet-read.component.html',
  styleUrls: ['./pet-read.component.css']
})
export class PetReadComponent implements AfterViewInit {

  pets: Pet[] = [];


  displayedColumnsPet: string[] = ['id', 'nome', 'dataNascimento','peso','especie', 'raca','cliente','funcionario','action'];
  dataSourcePet = new MatTableDataSource<Pet>(this.pets);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private service : PetService,
    private router : Router) {}

  ngAfterViewInit() {
    this.findAll();
  }

  findAll():void {
    this.service.findAll().subscribe((resposta) => {
      this.pets = resposta;
      this.dataSourcePet = new MatTableDataSource<Pet>(this.pets);
      this.dataSourcePet.paginator = this.paginator;
    })
  }

  navigateToCreatePet():void {
    this.router.navigate(['pet/cadastro'])
  }

}
