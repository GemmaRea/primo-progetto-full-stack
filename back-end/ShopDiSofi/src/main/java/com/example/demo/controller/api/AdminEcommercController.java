package com.example.demo.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Prodotto;

@RestController
public class AdminEcommercController {
	private List <Prodotto> list;

	public  AdminEcommercController() {
		list =  new ArrayList <Prodotto>();
		list.add(new Prodotto (1, "primoProdotto"));
		list.add(new Prodotto (2,"secondoProdotto"));
	}
	// ci mostra tutti i prodotti in file json ovviamente quelli memorizzati in prodotti
	@GetMapping("admin/api/prodotti")
	public Iterable<Prodotto> getAll(){
		 
		return list;
}
	// ci mostra un solo prodotto in base all'id che viene richiesto
	@GetMapping("admin/api/prodotti/{id}")
	public Prodotto getById (@PathVariable int id) {
		
		Optional <Prodotto> prodotto = list.stream().filter(item -> item.getId()==id).findFirst();
		 
		if (prodotto.isEmpty()) {
			
		
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		 }
		 return prodotto.get();
	
}
}
