package com.example.demo.service.medico;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Medico;
import com.example.demo.repository.IMedicoRepository;

@Service("mainMedicoService")
public class DbMedicoService implements IMedicoService {

	@Autowired
	private IMedicoRepository medicoRepository;

	@Override
	public Iterable<Medico> getAll() {

		return medicoRepository.findAll();
	}

	@Override
	public Optional<Medico> getById(int id) {

		return medicoRepository.findById(id);
	}

	@Override
	public Medico create(Medico medico) {

		return medicoRepository.save(medico);
	}

	@Override
	public Optional<Medico> update(int id, Medico medico) {

		Optional<Medico> trovaMedico = medicoRepository.findById(id);

		if (trovaMedico.isEmpty()) {
			return Optional.empty();
		}
		Medico medicoEsistente = trovaMedico.get();
		medicoEsistente.setNome(medico.getNome());
		medicoEsistente.setCognome(medico.getCognome());
		medicoEsistente.setSpecializzazione(medico.getSpecializzazione());
		medicoEsistente.setAssunto(medico.isAssunto());

		medicoRepository.save(medicoEsistente);
		return Optional.of(medicoEsistente);
		// return trovaMedico;
	}

	@Override
	public Boolean delete(int id) {

		Optional<Medico> trovaMedico = medicoRepository.findById(id);
		if (trovaMedico.isEmpty()) {
			return false;
		}
		// Imposta il campo 'assunto' su false
		Medico medicoEsistente = trovaMedico.get();
		medicoEsistente.setAssunto(false);

		// Salva il medico aggiornato
		medicoRepository.save(medicoEsistente);
		return true;
	}

	@Override
	public Boolean activate(int id) {

		Optional<Medico> trovaMedico = medicoRepository.findById(id);
		if (trovaMedico.isEmpty()) {
			return false;
		}

		Medico medicoEsistente = trovaMedico.get();
		medicoEsistente.setAssunto(true);

		// Salva il medico aggiornato
		medicoRepository.save(medicoEsistente);
		return true;
	}
}