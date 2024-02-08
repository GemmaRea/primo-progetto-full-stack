import { Medico } from "./medico";
import { Paziente } from "./paziente";

export class Visita {
    idVisita: number;
    tipoVisita: string;
    dataVisita: string;
    medico: Medico[];
    paziente: Paziente[];

    constructor(idVisita: number, tipoVisita: string, dataVisita: string, medico : Medico[], paziente: Paziente[]){
        this.idVisita = idVisita
        this.tipoVisita = tipoVisita
        this.dataVisita = dataVisita
        this.medico = medico
        this.paziente = paziente
    }
}
