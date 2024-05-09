package com.attusteste.gerenciador.controllers;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attusteste.gerenciador.entities.Person;

@RestController
@RequestMapping(value = "/people")
public class PersonController {
	
	@GetMapping
	public ResponseEntity<Person> findAll(){
		
		Person p1 = new Person(1l, "Eu", LocalDate.of(1997, 3, 30));
		
		return ResponseEntity.ok().body(p1);
	}

}
