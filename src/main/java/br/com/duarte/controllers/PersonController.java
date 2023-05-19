package br.com.duarte.controllers;

import br.com.duarte.models.Person;
import br.com.duarte.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping
    public List<Person> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable(name = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping()
    public Person insert(@RequestBody() Person person) {
        return service.insert(person);
    }

    @PutMapping()
    public Person update(@RequestBody() Person person) {
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
