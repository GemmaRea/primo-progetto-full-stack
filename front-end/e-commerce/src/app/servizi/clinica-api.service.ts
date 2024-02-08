import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Medico } from '../model/medico';
import { Paziente } from '../model/paziente';
import { Visita } from '../model/visita';

@Injectable({
  providedIn: 'root'
})
export class ClinicaApiService {

  constructor( private restApi: HttpClient) { }

 
  

  getMedicoUrl = "http://localhost:8080/api/medico"
  getMedico(): Observable<Medico[]> {
    return this.restApi.get<Medico[]>(this.getMedicoUrl);
  }
  getPazienteUrl = "http://localhost:8080/api/paziente"
  getPaziente(): Observable<Paziente[]> {
    return this.restApi.get<Paziente[]>(this.getPazienteUrl);
  }
  getVisitaUrl = "http://localhost:8080/api/visita"
  getVisita(): Observable<Visita[]> {
    return this.restApi.get<Visita[]>(this.getVisitaUrl);
  }
  postPazienteUrl = "http://localhost:8080/admin/api/paziente/aggiungi"
 postPaziente(paziente : Paziente): Observable<Paziente >{
  return this.restApi.post<Paziente>(this.postPazienteUrl,paziente)
 }
 putPazienteUrl = "http://localhost:8080/admin/api/paziente/aggiungi/"
 putPaziente(id: number, paziente: Paziente): Observable<Paziente> {
  const url = `${this.putPazienteUrl}/${id}`;
  return this.restApi.put<Paziente>(url, paziente);
}
  
}
