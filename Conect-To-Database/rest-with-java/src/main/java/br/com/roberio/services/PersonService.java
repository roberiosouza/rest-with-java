package br.com.roberio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.roberio.exceptions.ResourceNotFoundException;
import br.com.roberio.model.Person;
import br.com.roberio.repository.PersonRepository;

@Service
public class PersonService {
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public Person findById(Long id) {
		logger.info("Finding one Person");
		
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found."));
	}
	
	public List<Person> findAll() {
		logger.info("Finding all Persons");
		return repository.findAll();
	}
	
	public Person create(Person person) {
		logger.info("Creating one Person");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating one Person");
		
		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found."));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		entity.setAddress(person.getAddress());
		
		return repository.save(entity);
	}
	
	public ResponseEntity<?> delete(Long id) {
		logger.info("Deleting one Person");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found."));
		
		repository.delete(entity);
		return ResponseEntity.noContent().build();
	}
}
