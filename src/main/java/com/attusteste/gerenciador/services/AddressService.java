package com.attusteste.gerenciador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.attusteste.gerenciador.models.Address;
import com.attusteste.gerenciador.models.Person;
import com.attusteste.gerenciador.repositories.AddressRepository;

public class AddressService {
	
	@Autowired
	private AddressRepository ar;
	
	@Autowired
	private PersonService ps;
	
	public Address findById(Long id) {
		
		Optional<Address> address = this.ar.findById(id);
		return address.orElseThrow(() -> new RuntimeException("address not registered"));
	}
	
	@Transactional
	public Address create(Address a) {
		
		Person person = this.ps.findById(a.getPerson().getId());
		a.setId(null);
		a.setPerson(person);
		a = this.ar.save(a);
		return a;
	}
	
	@Transactional
	public Address update(Address a) {
		
		Address aux = findById(a.getId());
		aux.setCep(a.getCep());
		aux.setCity(a.getCity());
		aux.setNumber(a.getNumber());
		aux.setState(a.getState());
		aux.setStreet_address(a.getStreet_address());
		
		return this.ar.save(aux);
	}
	
	public List<Address> findAllByPersonId(Long PersonId){
		
		List<Address> address_list = this.ar.findByPerson_Id(PersonId);
		
		return address_list;
	}
}
