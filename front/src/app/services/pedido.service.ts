import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.prod';
import { Pedido } from '../models/pedido';


@Injectable({
  providedIn: 'root'
})
export class PedidoService {
  baseUrl: String = environment.baseUrl;

  constructor(
    private http: HttpClient,
    private snack: MatSnackBar
  ) { }

  findAll(): Observable<Pedido[]> {
    const url = this.baseUrl + "/pedido";
    return this.http.get<Pedido[]>(url);
  }

  findById(id : any):Observable<Pedido>{
    const url = `${this.baseUrl}/pedido/${id}`;
    return this.http.get<Pedido>(url);
  }

  /*update(pedido: Pedido):Observable<Pedido> {
    const url = `${this.baseUrl}/pedido/${pedido.id}`;
    return this.http.put<Pedido>(url, pedido);
  }*/

  delete(id : any):Observable<void> {
    const url = `${this.baseUrl}/pedido/${id}`;
    return this.http.delete<void>(url);
  }

  create(pedido: Pedido): Observable<Pedido> {
    const url = this.baseUrl + "/pedido/cadastro";
    return this.http.post<Pedido>(url, pedido);
  }

  message(msg: String): void {
    this.snack.open(`${msg}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }
}
