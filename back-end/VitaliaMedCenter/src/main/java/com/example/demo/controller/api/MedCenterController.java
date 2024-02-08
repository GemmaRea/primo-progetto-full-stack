package com.example.demo.controller.api;
// metodo REST

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.model.Prodotto;
import com.example.demo.service.IProdottoService;

// questo ci permette di trasformare il risultato in file json

// al controller interessa visualizzare i prodotti e ricercarli ma non interessa nessun altra operazione di crud in quanto spetta all'admin

@RestController
public class MedCenterController {

	@Autowired
	@Qualifier("mainProdottoService")
	private IProdottoService prodottoService;

	public MedCenterController() {
	}

	@GetMapping("/api/prodotti")

	public Iterable<Prodotto> getAll() {

		return prodottoService.getAll();
	}

	@GetMapping("/api/prodotti/{id}")
	public Prodotto getById(@PathVariable int id) {
		Optional<Prodotto> prodotto = prodottoService.getById(id);

		if (prodotto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}

		return prodotto.get();
	}
}
