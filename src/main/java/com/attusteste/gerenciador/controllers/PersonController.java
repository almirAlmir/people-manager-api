package com.attusteste.gerenciador.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.attusteste.gerenciador.models.Person;
import com.attusteste.gerenciador.services.PersonService;

@RestController
@RequestMapping("/people")
public class PersonController {
	
	@Autowired
	private PersonService ps;
	
	//caminho que listará todas as pessoas cadastradas no gerenciador
	@GetMapping
	public ResponseEntity<List<Person>> findAll(){
		
		//Person p1 = new Person(1l, "Eu", LocalDate.of(1997, 3, 30));
		
		return ResponseEntity.ok().body(ps.findAll());
	}
	//caminho que permitirá a consulta de qualquer pessoa cadastrada no gerenciador pelo id
	@GetMapping("/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id){
		
		Person person = this.ps.findById(id);
		
		return ResponseEntity.ok().body(person);
		
	}
	//caminho que permite o cadastro de uma pessoa no gerenciador
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Person person){
		
		this.ps.create(person);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(person.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	//caminho que permite a atualização dos dados(nome) de uma pessoa registrada no gerenciador
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Person person, @PathVariable Long id){
		
		person.setId(id);
		this.ps.update(person);
		
		return ResponseEntity.noContent().build();
	}

}
