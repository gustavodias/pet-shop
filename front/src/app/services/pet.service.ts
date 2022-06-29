import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.prod';
import { Pet } from '../models/pet';


@Injectable({
  providedIn: 'root'
})
export class PetService {
  baseUrl: String = environment.baseUrl;

  constructor(
    private http: HttpClient,
    private snack: MatSnackBar
  ) { }

  findAll(): Observable<Pet[]> {
    const url = this.baseUrl + "/pet";
    return this.http.get<Pet[]>(url);
  }

  findById(id : any):Observable<Pet>{
    const url = `${this.baseUrl}/pet/${id}`;
    return this.http.get<Pet>(url);
  }

  update(pet: Pet):Observable<Pet> {
    const url = `${this.baseUrl}/pet/${pet.id}`;
    return this.http.put<Pet>(url, pet);
  }

  updateSmart(json: {id: any; pet: String}):Observable<{id: any; pet: String}> {
    const url = `${this.baseUrl}/pet/${json.id}`;
    return this.http.put<{id: any; pet: String}>(url, json);
  }

  delete(id : any):Observable<void> {
    const url = `${this.baseUrl}/pet/${id}`;
    return this.http.delete<void>(url);
  }

  create(pet: Pet): Observable<Pet> {
    const url = this.baseUrl + "/pet/cadastro";
    return this.http.post<Pet>(url, pet);
  }

  message(msg: String): void {
    this.snack.open(`${msg}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }
}
