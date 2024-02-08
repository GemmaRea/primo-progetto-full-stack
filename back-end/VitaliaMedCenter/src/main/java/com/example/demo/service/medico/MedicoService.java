package com.example.demo.service.medico;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo.model.Medico;

@Service
public class MedicoService implements IMedicoService {

	private List<Medico> list;

	public MedicoService() {
	}

	// restituisce la lista con tutti i prodotti
	@Override
	public Iterable<Medico> getAll() {

		return list;
	}

	// prende l'id come parametro d'ingresso e restituisce un oggetto che conterrà
	// il prodotto (se trovato)
	@Override
	public Optional<Medico> getById(int id) {

		Optional<Medico> medico = list.stream().filter(item -> item.getIdMedico() == id).findFirst();

		return medico;
	}

// metodo create che prende in ingresso un oggetto prodotto da inserire nel db
// gli setta l'id lo aggiunge alla lista
// e lo restituisce
	@Override
	public Medico create(Medico medico) {
		list.add(medico);

		return medico;
	}

	// metodo update prende in input id del prodotto da modificare e l'oggetto
	// prodotto con i dati cerca il prodotto da modificare
	// tramite id se trova il prodotto lo modifica e lo restituisce aggiornato
	@Override
	public Optional<Medico> update(int id, Medico medico) {
		Optional<Medico> cercaMedico = list.stream().filter(item -> item.getIdMedico() == id).findFirst();

		if (cercaMedico.isEmpty()) {
			return Optional.empty();
		}

		return cercaMedico;
	}

	// metodo delete ricerca il prodotto per id se non esiste restituiamo false
	// altrimenti eliminiamo il prodotto
	@Override
	public Boolean delete(int id) {
		Optional<Medico> cercaMedico = list.stream().filter(item -> item.getIdMedico() == id).findFirst();

		if (cercaMedico.isEmpty()) {
			return false;
		}
		Medico medicoDaModificare = cercaMedico.get();
		medicoDaModificare.setAssunto(false);
		return true;

	}

	@Override
	public Boolean activate(int id) {
		Optional<Medico> cercaMedico = list.stream().filter(item -> item.getIdMedico() == id).findFirst();

		if (cercaMedico.isEmpty()) {
			return false;
		}
		Medico medicoDaModificare = cercaMedico.get();
		medicoDaModificare.setAssunto(true);
		return null;
	}
}
