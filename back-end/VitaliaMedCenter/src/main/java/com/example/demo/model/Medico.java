package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medico")
	private int idMedico;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "specializzazione")
	private String specializzazione;
	@Column(name = "assunto")
	private boolean assunto;
	@JsonIgnore
	@OneToMany(mappedBy = "idMedico") // al momento lascio cosi
	private Set<Visita> visite = new HashSet<Visita>();

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Medico(int idMedico) {
		super();
		this.idMedico = idMedico;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	public boolean isAssunto() {
		return assunto;
	}

	public void setAssunto(boolean assunto) {
		this.assunto = assunto;
	}

	public Set<Visita> getVisite() {
		return visite;
	}

	public void setVisite(Set<Visita> visite) {
		this.visite = visite;
	}

	@Override
	public String toString() {
		return "Medico [idMedico=" + idMedico + ", nome=" + nome + ", cognome=" + cognome + ", specializzazione="
				+ specializzazione + ", assunto=" + assunto + ", visite=" + visite + "]";
	}

	public Medico() {
	}

	public Medico(int idMedico, String nome, String cognome, String specializzazione, boolean assunto,
			Set<Visita> visite) {
		super();
		this.idMedico = idMedico;
		this.nome = nome;
		this.cognome = cognome;
		this.specializzazione = specializzazione;
		this.assunto = assunto;
		this.visite = visite;
	}

	public Medico(String nome, String cognome, String specializzazione) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.specializzazione = specializzazione;
	}

}
