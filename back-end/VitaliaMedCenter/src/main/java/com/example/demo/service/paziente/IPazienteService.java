package com.example.demo.service.paziente;

import java.util.Optional;

import com.example.demo.model.Paziente;

public interface IPazienteService {

	public Iterable<Paziente> getAll();

	public Optional<Paziente> getById(int id);

	public Paziente create(Paziente paziente);

	public Optional<Paziente> update(int id, Paziente paziente);

	public Boolean delete(int id);

	public Boolean activate(int id);

}
