import { Visita } from "./visita";

export class Medico {
    idMedico: number;
    nome: string;
    cognome: string;
    specializzazione: string;
    visite: Visita[];

    constructor(idMedico: number, nome: string, cognome: string, specializzazione: string, visite: Visita[]){
        this.idMedico = idMedico;
        this.nome = nome;
        this.cognome = cognome;
        this.specializzazione = specializzazione;
        this.visite = visite; 
    }
}
