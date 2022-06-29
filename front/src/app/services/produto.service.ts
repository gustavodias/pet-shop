import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.prod';
import { Produto } from '../models/produto';


@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  baseUrl: String = environment.baseUrl;

  constructor(
    private http: HttpClient,
    private snack: MatSnackBar
  ) { }

  findAll(): Observable<Produto[]> {
    const url = this.baseUrl + "/produto";
    return this.http.get<Produto[]>(url);
  }

  findById(id : any):Observable<Produto>{
    const url = `${this.baseUrl}/produto/${id}`;
    return this.http.get<Produto>(url);
  }

  update(produto: Produto):Observable<Produto> {
    const url = `${this.baseUrl}/produto/${produto.id}`;
    return this.http.put<Produto>(url, produto);
  }

  updateSmart(json: {id: any; produto: String}):Observable<{id: any; produto: String}> {
    const url = `${this.baseUrl}/produto/${json.id}`;
    return this.http.put<{id: any; produto: String}>(url, json);
  }

  delete(id : any):Observable<void> {
    const url = `${this.baseUrl}/produto/${id}`;
    return this.http.delete<void>(url);
  }

  create(produtoFull: Produto): Observable<Produto> {
    const url = this.baseUrl + "/produto/cadastro";
    return this.http.post<Produto>(url, produtoFull);
  }

  message(msg: String): void {
    this.snack.open(`${msg}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }
}
