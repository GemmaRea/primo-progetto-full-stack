package com.example.demo.controller.api;
// metodo REST

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Medico;
import com.example.demo.model.Paziente;
import com.example.demo.model.Visita;
import com.example.demo.service.medico.IMedicoService;
import com.example.demo.service.paziente.IPazienteService;
import com.example.demo.service.visita.IVisitaService;

// questo ci permette di trasformare il risultato in file json

// al controller interessa visualizzare i prodotti e ricercarli ma non interessa nessun altra operazione di crud in quanto spetta all'admin

@RestController
public class MedCenterController {

	@Autowired
	@Qualifier("mainMedicoService")
	private IMedicoService medicoService;

	@Autowired
	@Qualifier("mainPazienteService")
	private IPazienteService pazienteService;

	@Autowired
	@Qualifier("mainVisitaService")
	private IVisitaService visitaService;

	public MedCenterController() {
	}

	@CrossOrigin(origins = "http://localhost:4200")
	// getAll per le varie table
	// medico
	
	@GetMapping("/api/medico")

	public Iterable<Medico> getAllMedico() {

		return medicoService.getAll();
	}

	//restituisce le visite collegate ad un medico specifico
	@GetMapping("/api/medico/visite/{id}")

	public Set<Visita> getAllMedicoVisite(@PathVariable int id) {
		Optional<Medico> medicoOptional = medicoService.getById(id);
		if (medicoOptional.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medico non trovato con ID: " + id);
		}
		Medico medico = medicoOptional.get();
		return medico.getVisite();
	}	
	//restituisce le visite collegate ad un paziente specifico
	@GetMapping("/api/paziente/visite/{id}")

	public Set<Visita> getAllPazienteVisite(@PathVariable int id) {
		Optional<Paziente> pazienteOptional = pazienteService.getById(id);
		if (pazienteOptional.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paziente non trovato con ID: " + id);
		}
		Paziente paziente = pazienteOptional.get();
		return paziente.getVisite();
	}

	// paziente
	@GetMapping("/api/paziente")

	public Iterable<Paziente> getAllPaziente() {

		return pazienteService.getAll();
	}

	// Visita
	@GetMapping("/api/visita")
	public Iterable<Visita> getAllVisita() {

		return visitaService.getAll();
	}

	// visualizza un solo oggetto attraverso l'id
	// medico
	@GetMapping("/api/medico/{id}")
	public Medico getByIdMedico(@PathVariable int id) {

		Optional<Medico> medico = medicoService.getById(id);

		if (medico.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "medico non trovato");
		}

		return medico.get();
	}

	// paziente
	@GetMapping("/api/paziente/{id}")
	public Paziente getByIdPaziente(@PathVariable int id) {

		Optional<Paziente> paziente = pazienteService.getById(id);

		if (paziente.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "paziente non trovato");
		}

		return paziente.get();
	}

	// Visita
	@GetMapping("/api/visita/{id}")
	public Visita getByIdVisita(@PathVariable int id) {

		Optional<Visita> visita = visitaService.getById(id);

		if (visita.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "visita non trovata");
		}
		return visita.get();
	}
}
