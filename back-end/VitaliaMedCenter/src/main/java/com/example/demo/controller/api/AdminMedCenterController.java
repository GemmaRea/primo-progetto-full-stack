package com.example.demo.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.model.Medico;
import com.example.demo.model.Paziente;
import com.example.demo.model.Visita;
import com.example.demo.service.medico.IMedicoService;
import com.example.demo.service.paziente.IPazienteService;
import com.example.demo.service.visita.IVisitaService;

@RestController
public class AdminMedCenterController {

	@Autowired
	@Qualifier("mainMedicoService")
	private IMedicoService medicoService;

	@Autowired
	@Qualifier("mainPazienteService")
	private IPazienteService pazienteService;

	@Autowired
	@Qualifier("mainVisitaService")
	private IVisitaService visitaService;

	public AdminMedCenterController() {

	}
	
	@CrossOrigin(origins = "http://localhost:4200")

	// VISUALIZZA TUTTI
	// Medico
	@GetMapping("/admin/api/medico")
	public Iterable<Medico> getAllMedico() {

		return medicoService.getAll();
	}

	// Paziente
	@GetMapping("/admin/api/paziente")
	public Iterable<Paziente> getAllPaziente() {

		return pazienteService.getAll();
	}

	// Visita
	@GetMapping("/admin/api/visita")
	public Iterable<Visita> getAllVisita() {

		return visitaService.getAll();
	}

	// RICERCE PER ID
	// Medico
	@GetMapping("/admin/api/medico/{id}")
	public Medico getByIdMedico(@PathVariable int id) {

		Optional<Medico> medico = medicoService.getById(id);

		if (medico.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "medico non trovato");
		}
		return medico.get();

	}

	// Paziente
	@GetMapping("/admin/api/paziente/{id}")
	public Paziente getByIdPaziente(@PathVariable int id) {

		Optional<Paziente> paziente = pazienteService.getById(id);

		if (paziente.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "paziente non trovato");
		}
		return paziente.get();
	}

	// Visita
	@GetMapping("/admin/api/visita/{id}")
	public Visita getByIdVisita(@PathVariable int id) {

		Optional<Visita> visita = visitaService.getById(id);

		if (visita.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "visita non trovata");
		}
		return visita.get();
	}

	// METODO PER CREARE NUOVI Record INSEREND I VALORI
	// Medico
	@PostMapping(value = "/admin/api/medico/aggiungi", consumes = { MediaType.APPLICATION_JSON_VALUE,
			"application/json;charset=UTF-8" })
	public Medico create(@RequestBody Medico medico) {

		return medicoService.create(medico);
	}

	// Paziente
	@PostMapping(value = "/admin/api/paziente/aggiungi", consumes = { MediaType.APPLICATION_JSON_VALUE,
			"application/json;charset=UTF-8" })
	public Paziente create(@RequestBody Paziente paziente) {

		return pazienteService.create(paziente);
	}

	// Visita
	@PostMapping(value = "/admin/api/visita/aggiungi", consumes = { MediaType.APPLICATION_JSON_VALUE,
			"application/json;charset=UTF-8" })
	public Visita create(@RequestBody Visita visita) {

		return visitaService.create(visita);
	}

	// METODO UPDATE CHE PRENDE IN INGRESSO L'ID DEL PRODOTTO DA MODIFICARE
	// Medico
	@PutMapping(value = "/admin/api/medico/modifica/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			"application/json;charset=UTF-8" })
	public Medico update(@PathVariable int id, @RequestBody Medico medico) {

		Optional<Medico> aggiornaMedico = medicoService.update(id, medico);

		if (aggiornaMedico.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "medico non trovato");
		}

		return aggiornaMedico.get();
	}

	// Paziente
	@PutMapping(value = "/admin/api/paziente/modifica/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			"application/json;charset=UTF-8" })
	public Paziente update(@PathVariable int id, @RequestBody Paziente paziente) {

		Optional<Paziente> aggiornaPaziente = pazienteService.update(id, paziente);

		if (aggiornaPaziente.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "paziente non trovato");
		}

		return aggiornaPaziente.get();
	}

	// Visita
	@PutMapping(value = "/admin/api/visita/modifica/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			"application/json;charset=UTF-8" })
	public Visita update(@PathVariable int id, @RequestBody Visita visita) {

		Optional<Visita> aggiornaVisita = visitaService.update(id, visita);

		if (aggiornaVisita.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "visita non trovata");
		}

		return aggiornaVisita.get();
	}

	// METODO DELETE CHE PRENDE IN INGRESSO ID E LO ELIMINA o meglio lo disattiva
	// Medico
	@PutMapping("/admin/api/medico/disabilita/{id}")
	public void deleteMedico(@PathVariable int id) {

		Boolean isDelete = medicoService.delete(id);

		if (isDelete == false) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "medico non trovato");
		}

	}

	// Paziente
	@PutMapping("/admin/api/paziente/disabilita/{id}")
	public void deletePaziente(@PathVariable int id) {

		Boolean isDelete = pazienteService.delete(id);

		if (isDelete == false) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "paziente non trovato");
		}

	}

	@PutMapping("/admin/api/visita/annulla/{id}")
	public void deleteVisita(@PathVariable int id) {

		Boolean isDelete = visitaService.delete(id);

		if (isDelete == false) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "visita non trovata");
		}

	}

	// METODO activate CHE PRENDE IN INGRESSO ID E attiva
	// Medico
	@PutMapping("/admin/api/medico/abilita/{id}")
	public void activateMedico(@PathVariable int id) {

		Boolean isDelete = medicoService.activate(id);

		if (isDelete == false) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "medico non trovato");
		}

	}

	// Paziente
	@PutMapping("/admin/api/paziente/abilita/{id}")
	public void activatePaziente(@PathVariable int id) {

		Boolean isDelete = pazienteService.activate(id);

		if (isDelete == false) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "paziente non trovato");
		}

	}
}
