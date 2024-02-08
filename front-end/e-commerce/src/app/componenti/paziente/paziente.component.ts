import { Component } from '@angular/core';
import { Paziente } from '../../model/paziente';
import { ClinicaApiService } from '../../servizi/clinica-api.service';
import { MatTableModule } from '@angular/material/table';



@Component({
  selector: 'app-paziente',
  standalone: true,
  imports: [
    MatTableModule,
  ],
  templateUrl: './paziente.component.html',
  styleUrl: './paziente.component.css'
})
export class PazienteComponent {
  pazienti: Paziente[] = [];
  
  displayedColumns: string[] = ['id', 'nome', 'cognome', 'data di nascita', 'azioni'];

constructor(private clinicaApiService: ClinicaApiService) {

 }
 ngOnInit() {
  this.clinicaApiService.getPaziente().subscribe({
    next: (result) => {
      console.log("Il metodo è andato a buon fine");
      this.pazienti = result;
      console.log(this.pazienti);
 }
})
}
}
