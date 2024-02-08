import { Visita } from "./visita";

export class Paziente {
    idPaziente: number;
    nome: string;
    cognome: string;
    dataNascita: string;
    visite: Visita[];

    constructor(idPaziente: number, nome: string, cognome: string, dataNascita: string, visite: Visita[]){
        this.idPaziente = idPaziente
        this.nome = nome
        this.cognome = cognome
        this.dataNascita = dataNascita
        this.visite = visite; // Assumendo che visite sia un array di Visita
    }
}
