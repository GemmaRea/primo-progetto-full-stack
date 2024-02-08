package com.example.demo.service.medico;

import java.util.Optional;

import com.example.demo.model.Medico;

public interface IMedicoService {

	public Iterable<Medico> getAll();

	public Optional<Medico> getById(int id);

	public Medico create(Medico medico);

	public Optional<Medico> update(int id, Medico medico);

	public Boolean delete(int id);

	public Boolean activate(int id);
}
