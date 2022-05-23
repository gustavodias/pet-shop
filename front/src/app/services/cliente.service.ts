import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.prod';
import { Cliente } from '../models/cliente';
import { CLienteFull } from '../models/clientefull';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  baseUrl: String = environment.baseUrl;

  constructor(
    private http: HttpClient,
    private snack: MatSnackBar
  ) { }

  create(clienteFull: CLienteFull): Observable<CLienteFull> {
    const url = this.baseUrl + "/cliente/cadastro";
    return this.http.post<CLienteFull>(url, clienteFull);
  }

  message(msg: String): void {
    this.snack.open(`${msg}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }
}
