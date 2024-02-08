package com.example.demo.service.visita;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Visita;
import com.example.demo.repository.IVisitaRepository;

@Service("mainVisitaService")
public class DbVisitaService implements IVisitaService {

	@Autowired
	private IVisitaRepository visitaRepository;

	// VISUALIZZARE TUTTE LE VISITE
	@Override
	public Iterable<Visita> getAll() {

		return visitaRepository.findAll();
	}

	// VISUALIZZARE UNA VISITA
	@Override
	public Optional<Visita> getById(int id) {

		return visitaRepository.findById(id);
	}

	// CREARE UNA NUOVA VISITA
	@Override
	public Visita create(Visita visita) {

		return visitaRepository.save(visita);
	}

	// MODIFICARE UNA VISITA
	@Override
	public Optional<Visita> update(int id, Visita visita) {

		Optional<Visita> cercaVisita = visitaRepository.findById(id);

		if (cercaVisita.isEmpty()) {
			return Optional.empty();

		}
		Visita visitaModificata = cercaVisita.get();
		visitaModificata.setDataVisita(visita.getDataVisita());
		visitaModificata.setTipoVisita(visita.getTipoVisita());
		visitaModificata.setIdMedico(visita.getIdMedico());
		visitaModificata.setIdPaziente(visita.getIdPaziente());

		visitaRepository.save(visitaModificata);
		return Optional.of(visitaModificata);

	}

	// ANNULLARE LA VISITA
	@Override
	public Boolean delete(int id) {

		Optional<Visita> cercaVisita = visitaRepository.findById(id);
		if (cercaVisita.isEmpty()) {
			return false;
		}
		Visita visitaAnnullata = cercaVisita.get();
		visitaAnnullata.setDataVisita("annullata");
		visitaRepository.save(visitaAnnullata);
		return true;
	}

}
