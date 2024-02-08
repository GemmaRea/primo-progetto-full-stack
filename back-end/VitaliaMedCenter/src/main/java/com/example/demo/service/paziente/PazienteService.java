package com.example.demo.service.paziente;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Paziente;

@Service
public class PazienteService implements IPazienteService {

	private List<Paziente> list;

	public PazienteService() {

	}

	@Override
	public Iterable<Paziente> getAll() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Optional<Paziente> getById(int id) {

		Optional<Paziente> paziente = list.stream().filter(item -> item.getIdPaziente() == id).findFirst();

		return paziente;
	}

	@Override
	public Paziente create(Paziente paziente) {

		list.add(paziente);

		return paziente;
	}

	@Override
	public Optional<Paziente> update(int id, Paziente paziente) {

		Optional<Paziente> cercaPaziente = list.stream().filter(item -> item.getIdPaziente() == id).findFirst();

		if (cercaPaziente.isEmpty()) {
			return Optional.empty();
		}

		return cercaPaziente;
	}

	@Override
	public Boolean delete(int id) {

		Optional<Paziente> cercaPaziente = list.stream().filter(item -> item.getIdPaziente() == id).findFirst();

		if (cercaPaziente.isEmpty()) {
			return false;
		}
		Paziente pazienteDaModificare = cercaPaziente.get();
		pazienteDaModificare.setInCura(false);
		return true;
	}

	@Override
	public Boolean activate(int id) {

		Optional<Paziente> cercaPaziente = list.stream().filter(item -> item.getIdPaziente() == id).findFirst();

		if (cercaPaziente.isEmpty()) {
			return false;
		}
		Paziente pazienteDaModificare = cercaPaziente.get();
		pazienteDaModificare.setInCura(true);
		return true;
	}

}
