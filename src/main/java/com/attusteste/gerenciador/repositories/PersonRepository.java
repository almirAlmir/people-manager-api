package com.attusteste.gerenciador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attusteste.gerenciador.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
