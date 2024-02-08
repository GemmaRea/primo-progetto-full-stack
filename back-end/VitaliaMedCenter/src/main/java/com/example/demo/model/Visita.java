package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "visita")
public class Visita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_visita")
	private int idVisita;
	@Column(name = "tipo_visita")
	private String tipoVisita;
	@Column(name = "data_visita")
	private String dataVisita;

	@ManyToOne
	@JoinColumn(name = "id_medico", referencedColumnName = "id_medico")
	private Medico idMedico;
	@ManyToOne
	@JoinColumn(name = "id_paziente", referencedColumnName = "id_paziente")
	private Paziente idPaziente;

	public int getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}

	public String getTipoVisita() {
		return tipoVisita;
	}

	public void setTipoVisita(String tipoVisita) {
		this.tipoVisita = tipoVisita;
	}

	public String getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(String dataVisita) {
		this.dataVisita = dataVisita;
	}

	public Medico getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Medico idMedico) {
		this.idMedico = idMedico;
	}

	public Paziente getIdPaziente() {
		return idPaziente;
	}

	public void setIdPaziente(Paziente idPaziente) {
		this.idPaziente = idPaziente;
	}

	public Visita() {
		super();
	}

	public Visita(int idVisita, String tipoVisita, String dataVisita, Medico idMedico, Paziente idPaziente) {
		super();
		this.idVisita = idVisita;
		this.tipoVisita = tipoVisita;
		this.dataVisita = dataVisita;
		this.idMedico = idMedico;
		this.idPaziente = idPaziente;
	}

	@Override
	public String toString() {
		return "Visita [idVisita=" + idVisita + ", tipoVisita=" + tipoVisita + ", dataVisita=" + dataVisita
				+ ", idMedico=" + idMedico + ", idPaziente=" + idPaziente + "]";
	}

}
