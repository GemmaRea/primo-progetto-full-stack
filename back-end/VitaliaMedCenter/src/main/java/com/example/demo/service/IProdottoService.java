package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.model.Prodotto;

public interface IProdottoService {
	public Iterable<Prodotto> getAll();

	public Optional<Prodotto> getById(int id);

	public Prodotto create(Prodotto prodotto);

	public Optional<Prodotto> update(int id, Prodotto prodotto);

	public Boolean delete(int id);
}
