package br.com.duarte.controllers;

import br.com.duarte.data.vo.v1.PersonDTO;
import br.com.duarte.data.vo.v2.PersonDTOV2;
import br.com.duarte.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping
    public List<PersonDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public PersonDTO findById(@PathVariable(name = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping()
    public PersonDTO insert(@RequestBody() PersonDTO person) {
        return service.insert(person);
    }

    @PostMapping(value = "/v2")
    public PersonDTOV2 insertV2(@RequestBody() PersonDTOV2 person) {
        return service.insertV2(person);
    }

    @PutMapping()
    public PersonDTO update(@RequestBody() PersonDTO person) {
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
