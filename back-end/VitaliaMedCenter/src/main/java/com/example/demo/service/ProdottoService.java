package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Prodotto;

@Service("mainProdottoService")
public class ProdottoService implements IProdottoService {

	private List<Prodotto> list;

	private int lastId;

	public ProdottoService() {
		list = new ArrayList<Prodotto>();
		list.add(new Prodotto(1, "primoProdotto"));
		list.add(new Prodotto(2, "secondoProdotto"));

		lastId = 3;
	}

	// restituisce la lista con tutti i prodotti
	public Iterable<Prodotto> getAll() {

		return list;
	}

	// prende l'id come parametro d'ingresso e restituisce un oggetto che conterrà
	// il prodotto (se trovato)
	public Optional<Prodotto> getById(int id) {

		Optional<Prodotto> prodotto = list.stream().filter(item -> item.getId() == id).findFirst();

		return prodotto;
	}

// metodo create che prende in ingresso un oggetto prodotto da inserire nel db
// gli setta l'id lo aggiunge alla lista
// e lo restituisce
	public Prodotto create(Prodotto prodotto) {

		lastId++;
		prodotto.setId(lastId);
		list.add(prodotto);

		return prodotto;
	}

	// metodo update prende in input id del prodotto da modificare e l'oggetto
	// prodotto con i dati cerca il prodotto da modificare
	// tramite id se trova il prodotto lo modifica e lo restituisce aggiornato
	public Optional<Prodotto> update(int id, Prodotto prodotto) {
		Optional<Prodotto> trovaProdotto = list.stream().filter(item -> item.getId() == id).findFirst();

		if (trovaProdotto.isEmpty()) {
			return Optional.empty();
		}

		return trovaProdotto;
	}

	// metodo delete ricerca il prodotto per id se non esiste restituiamo false
	// altrimenti eliminiamo il prodotto
	public Boolean delete(int id) {
		Optional<Prodotto> trovaProdotto = list.stream().filter(item -> item.getId() == id).findFirst();

		if (trovaProdotto.isEmpty()) {
			return false;
		}

		list.remove(trovaProdotto.get());
		return true;

	}
}
