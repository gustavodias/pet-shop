import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.prod';
import { Cargo } from '../models/funcionario/cargo';

@Injectable({
  providedIn: 'root'
})
export class CargoService {
  baseUrl: String = environment.baseUrl;

  constructor(
    private http: HttpClient,
    private snack: MatSnackBar
  ) { }

  findAll(): Observable<Cargo[]> {
    const url = this.baseUrl + "/cargo";
    return this.http.get<Cargo[]>(url);
  }

  findById(id : any):Observable<Cargo>{
    const url = `${this.baseUrl}/cargo/${id}`;
    return this.http.get<Cargo>(url);
  }

  update(cargo: Cargo):Observable<Cargo> {
    const url = `${this.baseUrl}/cargo/${cargo.id}`;
    return this.http.put<Cargo>(url, cargo);
  }

  updateSmart(json: {id: any; cargo: String}):Observable<{id: any; cargo: String}> {
    const url = `${this.baseUrl}/cargo/${json.id}`;
    return this.http.put<{id: any; cargo: String}>(url, json);
  }

  delete(id : any):Observable<void> {
    const url = `${this.baseUrl}/cargo/${id}`;
    return this.http.delete<void>(url);
  }

  create(cargoFull: Cargo): Observable<Cargo> {
    const url = this.baseUrl + "/cargo/cadastro";
    return this.http.post<Cargo>(url, cargoFull);
  }

  message(msg: String): void {
    this.snack.open(`${msg}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }
}
