import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.prod';
import { Funcionario } from '../models/funcionario/funcionario';
import { FuncionarioFull } from '../models/funcionario/funcionariofull';
import { FuncionarioUpSmart } from '../models/funcionario/funcionarioUpSmart';
import { Cargo } from '../models/funcionario/cargo';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {
  baseUrl: String = environment.baseUrl;

  constructor(
    private http: HttpClient,
    private snack: MatSnackBar
  ) { }

  findAll(): Observable<Funcionario[]> {
    const url = this.baseUrl + "/funcionario";
    return this.http.get<Funcionario[]>(url);
  }

  findAllCargo(): Observable<Cargo[]> {
    const url = this.baseUrl + "/funcionario/cargos";
    return this.http.get<Cargo[]>(url);
  }

  findById(id : any):Observable<Funcionario>{
    const url = `${this.baseUrl}/funcionario/${id}`;
    return this.http.get<Funcionario>(url);
  }

  update(funcionario: Funcionario):Observable<Funcionario> {
    const url = `${this.baseUrl}/funcionario/${funcionario.id}`;
    return this.http.put<Funcionario>(url, funcionario);
  }

  updateSmart(json: {id: any; cargo: String}):Observable<{id: any; cargo: String}> {
    const url = `${this.baseUrl}/funcionario/${json.id}`;
    return this.http.put<{id: any; cargo: String}>(url, json);
  }

  delete(id : any):Observable<void> {
    const url = `${this.baseUrl}/funcionario/${id}`;
    return this.http.delete<void>(url);
  }

  create(funcionarioFull: FuncionarioFull): Observable<FuncionarioFull> {
    const url = this.baseUrl + "/funcionario/cadastro";
    return this.http.post<FuncionarioFull>(url, funcionarioFull);
  }

  message(msg: String): void {
    this.snack.open(`${msg}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }
}
