package com.example.demo.service.paziente;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Paziente;
import com.example.demo.repository.IPazienteRepository;

@Service("mainPazienteService")
public class DbPazienteService implements IPazienteService {

	@Autowired
	private IPazienteRepository pazienteRepository;

	@Override
	public Iterable<Paziente> getAll() {

		return pazienteRepository.findAll();
	}

	@Override
	public Optional<Paziente> getById(int id) {

		return pazienteRepository.findById(id);
	}

	@Override
	public Paziente create(Paziente paziente) {

		return pazienteRepository.save(paziente);
	}

	@Override
	public Optional<Paziente> update(int id, Paziente paziente) {

		Optional<Paziente> trovaPaziente = pazienteRepository.findById(id);

		if (trovaPaziente.isEmpty()) {
			return Optional.empty();
		}
		Paziente pazienteEsistente = trovaPaziente.get();
		pazienteEsistente.setNome(paziente.getNome());
		pazienteEsistente.setCognome(paziente.getCognome());
		pazienteEsistente.setDataNascita(paziente.getDataNascita());
		pazienteEsistente.setInCura(paziente.isInCura());

		pazienteRepository.save(pazienteEsistente);
		return Optional.of(pazienteEsistente);
		// return trovaPaziente
	}

	@Override
	public Boolean delete(int id) {

		Optional<Paziente> trovaPaziente = pazienteRepository.findById(id);

		if (trovaPaziente.isEmpty()) {
			return false;
		}
		Paziente pazienteEsistente = trovaPaziente.get();
		pazienteEsistente.setInCura(false);
		pazienteRepository.save(pazienteEsistente);
		return true;
	}

	@Override
	public Boolean activate(int id) {

		Optional<Paziente> trovaPaziente = pazienteRepository.findById(id);

		if (trovaPaziente.isEmpty()) {
			return false;
		}
		Paziente pazienteEsistente = trovaPaziente.get();
		pazienteEsistente.setInCura(true);
		pazienteRepository.save(pazienteEsistente);
		return true;
	}

}
