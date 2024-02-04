package com.example.demo.controller.api;


import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Prodotto;
import com.example.demo.service.ProdottoService;

@RestController
public class AdminMedCenterController {
	private ProdottoService prodottoService;
	
	public  AdminMedCenterController() {
	
		prodottoService = new ProdottoService();
	}
	//VISUALIZZA TUTTI I PRODOTTI
	@GetMapping("admin/api/prodotti")
	public Iterable<Prodotto> getAll(){
		 
		return prodottoService.getAll();
}
	//RICERCE PER ID
	@GetMapping("admin/api/prodotti/{id}")
	public Prodotto getById (@PathVariable int id) {
		
		Optional <Prodotto> prodotto = prodottoService.getById(id);
		 
		if (prodotto.isEmpty()) {
			
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		 }
		 return prodotto.get();
	
}
	// METODO PER CREARE NUOVI PRODOTTI INSEREND I VALORI 
	@PostMapping("/admin/api/prodotti")
	public Prodotto create(@RequestBody Prodotto prodotto) {

		return prodottoService.create(prodotto);
	}
	
	//METODO UPDATE CHE PRENDE IN INGRESSO L'ID DEL PRODOTTO DA MODIFICARE E
	@PutMapping("/admin/api/prodotti{id}")
	public Prodotto update(@PathVariable int id,@RequestBody Prodotto prodotto) {
		
		Optional <Prodotto> aggiornaProdotto = prodottoService.update(id, prodotto);
		 
		if (aggiornaProdotto.isEmpty()) {
			
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		 }
	
		return aggiornaProdotto.get();
	}
	
	//METODO DELETE CHE PRENDE IN INGRESSO ID E LO ELIMINA
	@DeleteMapping("/admin/api/prodotti{id}")
	public void delete(@PathVariable int id) {
		
		Boolean isDelete = prodottoService.delete(id);
		 
		if (isDelete == false) {
			
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		 }
	
}
}




