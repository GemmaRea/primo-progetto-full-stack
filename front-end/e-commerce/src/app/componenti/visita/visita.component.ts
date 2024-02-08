import { Component } from '@angular/core';
import { Visita } from '../../model/visita';
import { ClinicaApiService } from '../../servizi/clinica-api.service';

import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-visita',
  standalone: true,
  imports: [
    MatTableModule,
  ],
  templateUrl: './visita.component.html',
  styleUrl: './visita.component.css'
})
export class VisitaComponent {
  visite: Visita[] = [];
  
  displayedColumns: string[] = ['id', 'tipo', 'data', 'medico', 'paziente'];

constructor(private clinicaApiService: ClinicaApiService) {

 }
 ngOnInit() {
  this.clinicaApiService.getVisita().subscribe({
    next: (result) => {
      console.log("Il metodo è andato a buon fine");
      this.visite = result;
      console.log(this.visite);
 }
})
}
}
