package com.example.demo.service.visita;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.demo.model.Visita;

@Service
public class VisitaService implements IVisitaService {

	private List<Visita> list;

	public VisitaService() {
	}

	@Override
	public Iterable<Visita> getAll() {

		return list;
	}

	@Override
	public Optional<Visita> getById(int id) {

		Optional<Visita> visita = list.stream().filter(item -> item.getIdVisita() == id).findFirst();

		return visita;
	}

	@Override
	public Visita create(Visita visita) {

		list.add(visita);

		return visita;
	}

	@Override
	public Optional<Visita> update(int id, Visita visita) {

		Optional<Visita> cercaVisita = list.stream().filter(item -> item.getIdVisita() == id).findFirst();

		if (cercaVisita.isEmpty()) {
			return Optional.empty();
		}
		return cercaVisita;
	}

	@Override
	public Boolean delete(int id) {

		Optional<Visita> cercaVisita = list.stream().filter(item -> item.getIdVisita() == id).findFirst();

		if (cercaVisita.isEmpty()) {
			return false;

		}
		Visita visitaDaAnnullare = cercaVisita.get();
		visitaDaAnnullare.setDataVisita("annullata");
		return true;

	}

}
