import { Component } from '@angular/core';
import { Paziente } from '../../model/paziente';
import { ClinicaApiService } from '../../servizi/clinica-api.service';
import { MatTableModule } from '@angular/material/table';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule, FormsModule, } from '@angular/forms';




@Component({
  selector: 'app-paziente',
  standalone: true,
  imports: [
    MatTableModule,
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './paziente.component.html',
  styleUrl: './paziente.component.css'
})
export class PazienteComponent {

  pazienteSelezionatoId: number = 0;
  isCrea: boolean = false
  pazienti: Paziente[] = [];
  actionForm: FormGroup;
  displayedColumns: string[] = ['id', 'nome', 'cognome', 'data di nascita', 'azioni'];

  constructor(private formPaziente: FormBuilder, private clinicaApiService: ClinicaApiService) {
    this.actionForm = this.formPaziente.group({
      nome: ["", Validators.required],
      cognome: ["", Validators.required],
      dataNascita: ["", Validators.required]

    })

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
  inviaForm() {
    if ( this.actionForm.valid) {
      const nuovoPaziente: Paziente = new Paziente(
        this.actionForm.value.nome,
        this.actionForm.value.cognome,
        this.actionForm.value.dataNascita,
        true
      );

      this.clinicaApiService.postPaziente(nuovoPaziente).subscribe({
        next: (response: Paziente) => {
          console.log("Paziente creato con successo:", response);
          this.pazienti.unshift(nuovoPaziente);
          this.actionForm.reset();
        },
        error: (error: any) => {
          console.error("Errore durante la creazione del paziente:", error);
        }
      });

    } else if (this.isCrea === false && this.actionForm.valid) {
      const pazienteDaModificare = this.pazienti.find(paziente => paziente.idPaziente === this.pazienteSelezionatoId);
      if (pazienteDaModificare) {
        pazienteDaModificare.nome = this.actionForm.value.nome;
        pazienteDaModificare.cognome = this.actionForm.value.cognome;
        pazienteDaModificare.dataNascita = this.actionForm.value.dataNascita;

        this.clinicaApiService.putPaziente(this.pazienteSelezionatoId, pazienteDaModificare).subscribe({
          next: (response: Paziente) => {
            console.log("Paziente aggiornato con successo:", response);
            this.actionForm.reset();
          },
          error: (error: any) => {
            console.error("Errore durante l'aggiornamento del paziente:", error);
          }
        });

      } else {
        console.error("Paziente non trovato per l'id specificato.");
      }
    }
  }

}


