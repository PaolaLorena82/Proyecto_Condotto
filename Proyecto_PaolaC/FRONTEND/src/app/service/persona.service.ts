import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
URL = 'http://proyecto-plc.herokuapp.com/personas/';
  constructor(private http: HttpClient) {}

  public getPersona():Observable<persona>{
    return this.http.get<persona>(this.URL+'traer');
   }

    public findPersona():Observable<persona>{
      return this.http.get<persona>(this.URL+`traer/perfil`);
     }

    public save(persona: persona): Observable<any>{
      return this.http.post<any>(this.URL + 'crear', persona);
    }

    public update(id: number, persona: persona): Observable<any>{
      return this.http.put<any>(this.URL + `editar/${id}`, persona);
    }

    public delete(id: number): Observable<any>{
      return this.http.delete<any>(this.URL + `borrar/${id}`);
    }
  }

