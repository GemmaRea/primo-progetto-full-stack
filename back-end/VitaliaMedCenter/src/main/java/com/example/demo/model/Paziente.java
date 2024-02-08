package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "paziente")
public class Paziente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paziente")
	private int idPaziente;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "data_nascita")
	private String dataNascita;
	@Column(name = "in_cura", columnDefinition = "BOOLEAN DEFAULT true")
	private boolean inCura;
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "idPaziente") // al momento mi fermo qui
	private Set<Visita> visite = new HashSet<Visita>();

	public int getIdPaziente() {
		return idPaziente;
	}

	public void setIdPaziente(int idPaziente) {
		this.idPaziente = idPaziente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public boolean isInCura() {
		return inCura;
	}

	public void setInCura(boolean inCura) {
		this.inCura = inCura;
	}

	public Set<Visita> getVisite() {
		return visite;
	}

	public void setPazienti(Set<Visita> visite) {
		this.visite = visite;
	}

	public Paziente() {
	}

	public Paziente(String nome, String cognome, String dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}

	public Paziente(int idPaziente, String nome, String cognome, String dataNascita, boolean inCura,
			Set<Visita> visite) {
		super();
		this.idPaziente = idPaziente;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.inCura = inCura;
		this.visite = visite;
	}

	@Override
	public String toString() {
		return "Paziente [idPaziente=" + idPaziente + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita="
				+ dataNascita + ", inCura=" + inCura + ", visite=" + visite + "]";
	}

}
