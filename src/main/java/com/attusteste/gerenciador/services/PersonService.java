package com.attusteste.gerenciador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.attusteste.gerenciador.repositories.PersonRepository;
import com.attusteste.gerenciador.models.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository pr;
	
	public Person findById(Long id) {
		
		Optional<Person> person = this.pr.findById(id);
		
		return person.orElseThrow(() -> new RuntimeException("person not registred"));
	}
	
	@Transactional
	public Person create(Person p) {
		
		p.setId(null);
		p = this.pr.save(p);

		return p;
	}
	
	public List<Person> findAll(){
		return pr.findAll();
	}
	
	@Transactional
	public Person update(Person p) {
		
		Person aux = findById(p.getId());
		aux.setName(aux.getName());
		
		return this.pr.save(aux);
	}
	
}
