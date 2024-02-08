import { Component } from '@angular/core';
import { ClinicaApiService } from '../../servizi/clinica-api.service';
import { Medico } from '../../model/medico';
//angular material
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-medico',
  standalone: true,
  imports: [
    MatTableModule,
  ],
  templateUrl: './medico.component.html',
  styleUrl: './medico.component.css'
})
export class MedicoComponent {

  medici: Medico[] = [];
  
    displayedColumns: string[] = ['id', 'nome', 'cognome', 'specializzazione', 'azioni'];

  constructor(private clinicaApiService: ClinicaApiService) {

   }
   ngOnInit() {
    this.clinicaApiService.getMedico().subscribe({
      next: (result) => {
        console.log("Il metodo è andato a buon fine");
        this.medici = result;
        console.log(this.medici);
   }
  })


}
}