package br.com.duarte.services;

import br.com.duarte.models.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    public Person findById(String id) {
        log.info("Procurando uma pessoa...");

        var person =  new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Wallisson");
        person.setLastName("Duarte");
        person.setAddress("Brasil - Distrito Federal - Gama");
        person.setGender("Masculino");
        return person;
    }

}
