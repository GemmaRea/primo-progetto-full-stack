package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
// qui andiamo a creare rotte che grazie a thymelaf possiamo aggiungere pagine html nella sezione main resources in un folder templates
// mentre per il css ed immaggini basta inserirle all'nterno di una folder static sempre in main resource e mettendo il path e come ritorno 
// solo nome file senza estensione e per far funzionare tutto bisogna eliminare l'annotation responseBody ed aggiungere in application.propriertes
// questo pezzettino di codice per evitare che il file html con reindirizzamente compresi di estensione non vengano riconosciuti da java questo è il
// codice da inserire è: spring.thymeleaf.cache = false.
@Controller
public class HomeController {
	
	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "Hello World";
	}
	@GetMapping("/demo")
	@ResponseBody
	public String demo() {
		return "Questo  è la pagina demo";
	}
}
