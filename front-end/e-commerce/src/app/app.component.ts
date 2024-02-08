import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { MedicoComponent } from './componenti/medico/medico.component';
import { PazienteComponent } from './componenti/paziente/paziente.component';
import { VisitaComponent } from './componenti/visita/visita.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, MedicoComponent,PazienteComponent,VisitaComponent ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'e-commerce';
}
