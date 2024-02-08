package com.example.demo.service.visita;

import java.util.Optional;

import com.example.demo.model.Visita;

public interface IVisitaService {
	public Iterable<Visita> getAll();

	public Optional<Visita> getById(int id);

	public Visita create(Visita visita);

	public Optional<Visita> update(int id, Visita visita);

	public Boolean delete(int id);

}
