import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.prod';
import { Cliente } from '../models/cliente';
import { ClienteFull} from '../models/clientefull';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  baseUrl: String = environment.baseUrl;

  constructor(
    private http: HttpClient,
    private snack: MatSnackBar
  ) { }

  findAll(): Observable<Cliente[]> {
    const url = this.baseUrl + "/cliente";
    return this.http.get<Cliente[]>(url);
  }

  findById(id : any):Observable<Cliente>{
    const url = `${this.baseUrl}/cliente/${id}`;
    return this.http.get<Cliente>(url);
  }

  update(cliente: Cliente):Observable<Cliente> {
    const url = `${this.baseUrl}/cliente/${cliente.id}`;
    return this.http.put<Cliente>(url, cliente);
  }

  updateSmart(json: {id: any; cliente: String}):Observable<{id: any; cliente: String}> {
    const url = `${this.baseUrl}/cliente/${json.id}`;
    return this.http.put<{id: any; cliente: String}>(url, json);
  }

  delete(id : any):Observable<void> {
    const url = `${this.baseUrl}/cliente/${id}`;
    return this.http.delete<void>(url);
  }

  create(clienteFull: ClienteFull): Observable<ClienteFull> {
    const url = this.baseUrl + "/cliente/cadastro";
    return this.http.post<ClienteFull>(url, clienteFull);
  }

  message(msg: String): void {
    this.snack.open(`${msg}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }
}
