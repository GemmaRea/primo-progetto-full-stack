package com.example.demo.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Prodotto;

@RestController
public class AdminMedCenterController {
	private List <Prodotto> list;
	private int lastId;
	public  AdminMedCenterController() {
		list =  new ArrayList <Prodotto>();
		list.add(new Prodotto (1, "primoProdotto"));
		list.add(new Prodotto (2,"secondoProdotto"));
		
		lastId = 3;
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
	// metodo post per aggiungere un prodotto all'interno del DB fittizzio inserendo i dati da aggiungere 
	//e permette di visualizzare il prodotto inserito
	@PostMapping("/admin/api/prodotti")
	public Prodotto create(@RequestBody Prodotto prodotto) {
	 
		lastId ++;
		prodotto.setId(lastId);
		list.add(prodotto);
		
		return prodotto;
	}
	//metodo put per modificare un prodotto, LO RICERCHIAMO TRAMITE ID E MODIFICHIAMO URL DELLA STRINGA ALL'ID CORRISPONDENTE 
	//E POI RESTITUIAMO IL PRODOTTO AGGIORNATO esiste il try in caso l'id non è presente nel db
	@PutMapping("/admin/api/prodotti{id}")
	public Prodotto update(@PathVariable int id,@RequestBody Prodotto prodotto) {
		Optional <Prodotto> trovaProdotto = list.stream().filter(item -> item.getId()==id).findFirst();
		 
		if (trovaProdotto.isEmpty()) {
			
		
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		 }
	
		trovaProdotto.get().setUrl(prodotto.getUrl());
		return trovaProdotto.get();
	}
	
	//metodo delete per eliminare un prodotto grazie al suo id
	@DeleteMapping("/admin/api/prodotti{id}")
	public void delete(@PathVariable int id) {
		Optional <Prodotto> trovaProdotto = list.stream().filter(item -> item.getId()==id).findFirst();
		 
		if (trovaProdotto.isEmpty()) {
			
		
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		 }
	
		list.remove(trovaProdotto.get());

}
}




