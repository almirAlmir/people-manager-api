package com.attusteste.gerenciador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attusteste.gerenciador.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address ,Long>{

}
