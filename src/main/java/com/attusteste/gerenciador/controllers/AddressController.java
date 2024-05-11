package com.attusteste.gerenciador.controllers;

import java.net.URI;
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

import com.attusteste.gerenciador.models.Address;
import com.attusteste.gerenciador.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService as;
	
	@GetMapping("/person/{personId}")
	public ResponseEntity<List<Address>> findAllByPersonId(@PathVariable Long personId){
		
		List<Address> addresses = this.as.findAllByPersonId(personId);
		
		return ResponseEntity.ok().body(addresses);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Address> findById(@PathVariable Long id){
		Address address = this.as.findById(id);
		
		return ResponseEntity.ok().body(address);
	}
	
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Address address){
		this.as.create(address);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(address.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Address address, @PathVariable Long id){
		
		address.setId(id);
		this.as.update(address);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
