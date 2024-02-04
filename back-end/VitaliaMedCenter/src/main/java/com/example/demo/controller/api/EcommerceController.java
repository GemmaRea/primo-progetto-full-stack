package com.example.demo.controller.api;
// metodo REST
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Prodotto;
// questo ci permette di trasformare il risultato in file json

//
@RestController
public class EcommerceController {
	
	// ci mostra tutti i prodotti in file json ovviamente quelli memorizzati in prodotti
	@GetMapping("/api/prodotti")
	/*possiamo rendere il tutto dinamico in questo modo:
	 * 
    @GetMapping("/api/{tipo}")
    public <T> Iterable<T> getAll(@PathVariable String tipo) {
        List<T> list;
        
        switch (tipo.toLowerCase()) {
            case "prodotti":
                list = (List<T>) generateDynamicProductList();
                break;
            case "utenti":
                list = (List<T>) generateDynamicUserList();
                break;
            default:
                throw new IllegalArgumentException("Tipo non supportato: " + tipo);
        }

        return list;
	 */
public Iterable<Prodotto> getAll(){
		List <Prodotto> list = new ArrayList <Prodotto>();
		return list;
}
	// ci mostra un solo prodotto in base all'id che viene richiesto
	@GetMapping("/api/prodotti/{id}")
	public Prodotto getById (@PathVariable int id) {
		List <Prodotto> list = new ArrayList <Prodotto>();
		Optional <Prodotto> prodotto = list.stream().filter(item -> item.getId()==id).findFirst();
		 if (prodotto.isEmpty()) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		 }
		 return prodotto.get();
	}
}
