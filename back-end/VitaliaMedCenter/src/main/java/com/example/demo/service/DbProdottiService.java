package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Prodotto;

@Service
public class DbProdottiService implements IProdottoService {

	public Iterable<Prodotto> getAll() {

		return new ArrayList<Prodotto>();
	}

	public Optional<Prodotto> getById(int id) {

		return Optional.empty();
	}

	public Prodotto create(Prodotto prodotto) {

		return null;
	}

	public Optional<Prodotto> update(int id, Prodotto prodotto) {

		return Optional.empty();
	}

	public Boolean delete(int id) {

		return false;
	}
}
