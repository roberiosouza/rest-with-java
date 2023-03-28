package br.com.roberio.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.roberio.model.Person;

@Service
public class PersonService {
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public Person findById(String id) {
		logger.info("Finding one Person");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Mock 1");
		person.setLastName("End Mock 1");
		person.setGender("Gender Mock 1");
		person.setAddress("Address Mock 1");
		
		return person;
	}
	
	public List<Person> findAll() {
		logger.info("Finding all Persons");
		List<Person> persons = new ArrayList<>();
		
		for (int i = 1; i < 9; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
	}
	
	public Person create(Person person) {
		logger.info("Creating one Person");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating one Person");
		
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting one Person");
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Mock " + i);
		person.setLastName("End Mock " + i);
		person.setGender("Gender Mock " + i);
		person.setAddress("Address Mock " + i);
		
		return person;
	}
}
