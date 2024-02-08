import { Visita } from "./visita";

export class Paziente {
    idPaziente?: number;
    nome: string;
    cognome: string;
    dataNascita: string;
    inCura?: boolean
    visite?: Visita[];

    constructor( nome: string, cognome: string, dataNascita: string, inCura:boolean, visite?: Visita[],idPaziente?: number){
        this.idPaziente = idPaziente
        this.nome = nome
        this.cognome = cognome
        this.dataNascita = dataNascita
        this.inCura = inCura;
        this.visite = visite; // Assumendo che visite sia un array di Visita
    }
}
