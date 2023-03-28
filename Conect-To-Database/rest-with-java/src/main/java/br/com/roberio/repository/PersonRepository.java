package br.com.roberio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.roberio.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
