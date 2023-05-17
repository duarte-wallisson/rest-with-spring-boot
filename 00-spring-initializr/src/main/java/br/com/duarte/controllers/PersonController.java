package br.com.duarte.controllers;

import br.com.duarte.models.Person;
import br.com.duarte.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping("/{id}")
    public Person findById (@PathVariable(name = "id") String id) {
        return service.findById(id);
    }
}
