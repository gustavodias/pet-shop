import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.prod';
import { Servico } from '../models/servico';



@Injectable({
  providedIn: 'root'
})
export class ServicoService {
  baseUrl: String = environment.baseUrl;

  constructor(
    private http: HttpClient,
    private snack: MatSnackBar
  ) { }

  findAll(): Observable<Servico[]> {
    const url = this.baseUrl + "/servico";
    return this.http.get<Servico[]>(url);
  }

  findById(id : any):Observable<Servico>{
    const url = `${this.baseUrl}/servico/${id}`;
    return this.http.get<Servico>(url);
  }

  update(servico: Servico):Observable<Servico> {
    const url = `${this.baseUrl}/servico/${servico.id}`;
    return this.http.put<Servico>(url, servico);
  }

  updateSmart(json: {id: any; servico: String}):Observable<{id: any; servico: String}> {
    const url = `${this.baseUrl}/servico/${json.id}`;
    return this.http.put<{id: any; servico: String}>(url, json);
  }

  delete(id : any):Observable<void> {
    const url = `${this.baseUrl}/servico/${id}`;
    return this.http.delete<void>(url);
  }

  create(servicoFull: Servico): Observable<Servico> {
    const url = this.baseUrl + "/servico/cadastro";
    return this.http.post<Servico>(url, servicoFull);
  }

  message(msg: String): void {
    this.snack.open(`${msg}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }
}
