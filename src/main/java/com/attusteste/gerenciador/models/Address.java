package com.attusteste.gerenciador.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address_tb")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	@Column(name = "street")
	private String street_address;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "main_address")
	private Boolean main_address;

	public Address() {
		
	}
	
	

	public Address(Long id, Person person, String street_address, String cep, String number, String city,
			String state, Boolean main_address) {
		super();
		this.id = id;
		this.person = person;
		this.street_address = street_address;
		this.cep = cep;
		this.number = number;
		this.city = city;
		this.state = state;
		this.main_address = main_address;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getMain_address() {
		return main_address;
	}

	public void setMain_address(Boolean main_address) {
		this.main_address = main_address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, city, id, number, person, state, street_address);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(city, other.city) && Objects.equals(id, other.id)
				&& Objects.equals(number, other.number) && Objects.equals(person, other.person)
				&& Objects.equals(state, other.state) && Objects.equals(street_address, other.street_address);
	}
	
	
	
	
}
