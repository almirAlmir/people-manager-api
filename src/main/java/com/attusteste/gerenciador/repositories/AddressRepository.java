package com.attusteste.gerenciador.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attusteste.gerenciador.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address ,Long>{
	
	List<Address> findByPerson_Id(Long id);
}
