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
        log.info("Procurando uma pessoa...");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com esse ID!"));
    }

    public List<Person> findAll() {
        log.info("Procurando todas as pessoas...");

        return repository.findAll();
    }

    public Person insert(Person person) {
        log.info("Inserindo uma pessoa.");

        return repository.save(person);
    }

    public Person update(Person person) {
        log.info("Atualizando uma pessoa.");

        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com esse ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(person);
    }

    public void delete(Long id) {
        log.info("Deletando uma pessoa.");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com esse ID!"));
        repository.delete(entity);
    }

}
