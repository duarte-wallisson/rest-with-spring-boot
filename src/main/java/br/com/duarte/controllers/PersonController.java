package br.com.duarte.controllers;

import br.com.duarte.data.vo.v1.PersonVO;
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
    public List<PersonVO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public PersonVO findById(@PathVariable(name = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping()
    public PersonVO insert(@RequestBody() PersonVO person) {
        return service.insert(person);
    }

    @PutMapping()
    public PersonVO update(@RequestBody() PersonVO person) {
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
