package br.com.duarte.services;

import br.com.duarte.models.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    public Person findById(String id) {
        log.info("Procurando uma pessoa...");

        var person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Wallisson");
        person.setLastName("Duarte");
        person.setAddress("Brasil - Distrito Federal - Gama");
        person.setGender("Masculino");
        return person;
    }

    public List<Person> findAll() {
        log.info("Procurando todas as pessoas...");

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person insert(Person person) {
        log.info("Inserindo uma pessoa.");

        return person;
    }

    public Person update(Person person) {
        log.info("Atualizando uma pessoa.");

        return person;
    }

    public void delete(String id) {
        log.info("Deletando uma pessoa.");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Nome: " + i);
        person.setLastName("Sobrenome: " + i);
        person.setAddress("Algum lugar do Brasil...");
        person.setGender("Não definido");
        return person;
    }
}
