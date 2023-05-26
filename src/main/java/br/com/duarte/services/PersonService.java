package br.com.duarte.services;

import br.com.duarte.exceptions.ResourceNotFoundException;
import br.com.duarte.models.Person;
import br.com.duarte.repositories.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonService {

    @Autowired
    PersonRepository repository;
    public Person findById(Long id) {
        log.info("looking for a person.");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
    }

    public List<Person> findAll() {
        log.info("Looking for people.");

        return repository.findAll();
    }

    public Person insert(Person person) {
        log.info("Inserting a person.");

        return repository.save(person);
    }

    public Person update(Person person) {
        log.info("Update a person.");

        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(person);
    }

    public void delete(Long id) {
        log.info("Remove a person.");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        repository.delete(entity);
    }

}
